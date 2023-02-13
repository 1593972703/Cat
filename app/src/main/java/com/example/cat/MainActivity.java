package com.example.cat;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.cat.adapter.TextAdapter;
import com.example.cat.bean.CatAttrBean;
import com.example.cat.bean.CatBean;
import com.example.cat.bean.PicBean;
import com.example.cat.databinding.ActivityMainBinding;
import com.example.cat.greendao.DaoManager;
import com.nianlun.greendao.gen.DaoSession;
import com.tencent.mmkv.MMKV;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.listener.OnPageChangeListener;
import com.youth.banner.transformer.RotateUpPageTransformer;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ActivityMainBinding mainBinding;
    private List<String> curThemes;
    private List<CatBean> catBeans;
    private List<CatAttrBean> catAttrBeans;

    private MyDialog typeDialog, themeDialog;
    private List<PicBean> picBeanList = new ArrayList<>();
    BannerImageAdapter<PicBean> bannerImageAdapter;

    private TextAdapter adapter;
    private List<CatAttrBean> catAttrBeanList = new ArrayList<>();

    private String curThem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public void loadData() {

    }


    @Override
    public void initView() {

        initDataBase();


        curThemes = getThemes(Constant.TYPES[0]);
        curThem = "血月之殇";
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initType();
        mainBinding.include.setTitle("猫猫列表");
        mainBinding.include.leftBtn.setVisibility(View.GONE);
        mainBinding.include.rightBtn.setVisibility(View.GONE);
        initXBanner(Constant.TYPES[0]);
        initRecyclerView();
    }

    private void initRecyclerView() {
        if (adapter == null) {
            mainBinding.listView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new TextAdapter(catAttrBeanList);
            mainBinding.listView.setAdapter(adapter);
        }
        getAttrFromCat();
        adapter.notifyDataSetChanged();


    }

    private void initDataBase() {
        MMKV.initialize(this);
        MMKV kv = MMKV.defaultMMKV();
        Log.e(TAG, "onCreate: " + kv.decodeBool("first"));

        try {
            if (!kv.decodeBool("first"))
                copyDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DaoManager.getInstance().init(getApplication());
        DaoSession daoSession = DaoManager.getInstance().getDaoMaster().newSession();
        catBeans = daoSession.getCatBeanDao().loadAll();
        catAttrBeans = daoSession.getCatAttrBeanDao().loadAll();
    }

    private void initType() {
        mainBinding.tvType.setText("布偶");
        mainBinding.tvTheme.setText("血月之殇");

        mainBinding.tvType.setOnClickListener(v -> {
            if (typeDialog == null)
                typeDialog = new MyDialog(MainActivity.this, position -> {
                    mainBinding.tvType.setText(Constant.TYPES[position]);
                    curThemes = getThemes(Constant.TYPES[position]);
                    mainBinding.tvTheme.setText(curThemes.get(0));
                    initXBanner(Constant.TYPES[position]);
                    initRecyclerView();
                });

            typeDialog.show();
            typeDialog.setList(Arrays.asList(Constant.TYPES));
        });

        mainBinding.tvTheme.setOnClickListener(v -> {
            if (themeDialog == null)
                themeDialog = new MyDialog(MainActivity.this,
                        position ->
                        {
                            mainBinding.tvTheme.setText(curThemes.get(position));
                            mainBinding.xbanner.setCurrentItem(position + 1);
                        });
            themeDialog.show();
            themeDialog.setList(curThemes);
        });


    }

    private void initXBanner(String type) {
        getPicList(type);
        mainBinding.xbanner.isAutoLoop(false);

        mainBinding.xbanner.addPageTransformer(new RotateUpPageTransformer());
        if (bannerImageAdapter == null) {
            bannerImageAdapter = new BannerImageAdapter<PicBean>(picBeanList) {
                @Override
                public void onBindView(BannerImageHolder holder, PicBean data, int position, int size) {
                    holder.imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    RoundedCorners roundedCorners = new RoundedCorners(20);
                    Glide.with(MainActivity.this).load(data.url)
                            .apply(RequestOptions.bitmapTransform(roundedCorners))
                            .into(holder.imageView);
                    Log.e(TAG, "onBindView: " + data.url);

                }    //图片加载自己实现
            };
            mainBinding.xbanner.setAdapter(bannerImageAdapter);

        }
        mainBinding.xbanner.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mainBinding.tvTheme.setText(curThemes.get(position));
                Log.e(TAG, "onPageSelected: " + curThemes.get(position));
                curThem = curThemes.get(position);
                initRecyclerView();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private String getPinyin(String theme) {
        char[] chars = theme.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char aa : chars) {
            HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
            outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            try {
                String[] pinyin = PinyinHelper.toHanyuPinyinStringArray(aa, outputFormat);
                for (String re : pinyin) {
                    stringBuilder.append(re);
                }
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }

        }
        return stringBuilder.toString();
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = this.getAssets().open("cat.db");
        File outFileName = this.getDatabasePath("cat.db");
//        if (outFileName.exists() && outFileName.isFile()) {
//            Log.e(TAG, "copyDataBase: " + "数据库已存在");
//            return;
//        }
        outFileName.getParentFile().mkdirs();
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
        MMKV.defaultMMKV().encode("first", true);
    }

    private List<String> getThemes(String type) {
        List<String> list = new ArrayList<>();
        for (CatBean bean : catBeans) {
            if (bean.getType().equals(type))
                list.add(bean.getTheme());
        }
        return list;
    }

    private void getPicList(String type) {
        picBeanList.clear();
        if (catBeans == null)
            return;
        for (CatBean bean : catBeans) {
            String picName = bean.getPicname();
            if (type.equals(bean.getType())) {
                Log.e(TAG, "getPicList: " + picName);
                int url = getResources().getIdentifier(picName, "mipmap", getPackageName());
                picBeanList.add(new PicBean(url, bean.getTheme()));
            }
        }

        if (!picBeanList.isEmpty()) {
            curThem = picBeanList.get(0).theme;
        }
        if (bannerImageAdapter != null) {
            mainBinding.xbanner.setCurrentItem(1);
            bannerImageAdapter.notifyDataSetChanged();

        }
    }

    private void getAttrFromCat() {
        catAttrBeanList.clear();
        for (CatAttrBean catAttrBean : catAttrBeans) {
            if (catAttrBean.getTheme().equals(curThem)) {
                catAttrBeanList.add(catAttrBean);
            }
        }
    }


}