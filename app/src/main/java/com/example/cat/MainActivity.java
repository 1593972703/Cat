package com.example.cat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.cat.bean.CatBean;
import com.example.cat.bean.PicBean;
import com.example.cat.databinding.ActivityMainBinding;
import com.example.cat.greendao.DaoManager;
import com.example.cat.utils.ScreenUtils;
import com.nianlun.greendao.gen.CatAttrBeanDao;
import com.nianlun.greendao.gen.CatBeanDao;
import com.nianlun.greendao.gen.DaoMaster;
import com.nianlun.greendao.gen.DaoSession;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.transformer.RotateDownPageTransformer;

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
import java.util.List;
import java.util.SimpleTimeZone;


public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ActivityMainBinding mainBinding;
    private List<String> curThemes;
    private List<CatBean> catBeans;


    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        try {
////            copyDataBase();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }


    @Override
    public void loadData() {


    }

    @Override
    public void initView() {
        DaoManager.getInstance().init(getApplication());
        DaoSession daoSession = DaoManager.getInstance().getDaoMaster().newSession();
        catBeans = daoSession.getCatBeanDao().loadAll();


        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.include.setTitle("猫猫列表");
        mainBinding.include.leftBtn.setVisibility(View.GONE);
        mainBinding.include.rightBtn.setVisibility(View.GONE);
        curThemes = getThemes(Constant.TYPES[0]);

        mainBinding.spinnerType.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spinner, Constant.TYPES));
        mainBinding.spinnerTheme.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spinner, curThemes));
        mainBinding.spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mainBinding.spinnerTheme.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                        R.layout.item_spinner, Constant.THEMES[position]));
                curThemes = getThemes(Constant.TYPES[position]);
                initXBanner(Constant.TYPES[position]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        initXBanner(Constant.TYPES[0]);
    }

    private void initXBanner(String type) {
        List<PicBean> picBeanList = new ArrayList<>();
        if (catBeans == null)
            return;
        for (CatBean bean : catBeans) {
            String picName = bean.getPicname();
            if (type.equals(bean.getType())) {
                int url = getResources().getIdentifier(picName, "mipmap", getPackageName());
                picBeanList.add(new PicBean(url, bean.getTheme()));
            }

        }

        mainBinding.xbanner.isAutoLoop(false);
        mainBinding.xbanner.addPageTransformer(new RotateDownPageTransformer());
        mainBinding.xbanner.setAdapter(new BannerImageAdapter<PicBean>(picBeanList) {
            @Override
            public void onBindView(BannerImageHolder holder, PicBean data, int position, int size) {

                Glide.with(MainActivity.this).load(data.url)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                        .into(holder.imageView);
                mainBinding.spinnerTheme.setSelection(position);

            }    //图片加载自己实现


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
    }

    private List<String> getThemes(String type) {
        List<String> list = new ArrayList<>();
        for (CatBean bean : catBeans) {
            if (bean.getType().equals(type))
                list.add(bean.getTheme());
        }
        return list;
    }


}