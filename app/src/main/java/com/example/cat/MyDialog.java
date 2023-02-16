package com.example.cat;


import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.example.cat.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MyDialog extends AlertDialog {

    private Context mContext;
    private List<String> stringList = new ArrayList<>();
    private ArrayAdapter<String> stringArrayAdapter;
    private OnClickListener onClickListener;

    protected MyDialog(@NonNull Context context, OnClickListener onClickListener) {
        super(context);
        this.mContext = context;
        this.onClickListener = onClickListener;
    }


    protected MyDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public void setList(List<String> stringList) {
        this.stringList.clear();
        this.stringList.addAll(stringList);
        if (stringArrayAdapter != null)
            stringArrayAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        ListView listView = new ListView(mContext);
        setContentView(listView);

        listView.setDivider(null);
        listView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        stringArrayAdapter = new ArrayAdapter<>(mContext, R.layout.item_spinner, stringList);
        listView.setAdapter(stringArrayAdapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            if (onClickListener != null)
                onClickListener.onItemClick(position);

            dismiss();
        });
        getWindow().setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.bg_button));

        getWindow().setLayout(
                ScreenUtils.getScreenWidth(mContext) * 3 / 5,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
    }

    public interface OnClickListener {
        void onItemClick(int position);
    }
}
