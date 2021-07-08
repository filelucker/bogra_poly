package com.bograpoly.emp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private static final String TAG = MainActivity.class.getSimpleName();
    static ImageView imageView;

    String[] nameList = {"মোঃ আজিজুল আমান আল আমিন", "মোহাম্মদ আলী", "মোঃ- হুমায়ূন রেজা", "মোছাঃ- মৌসূমী খাতুন"};
    String[] numberList = {"01712685203", "01712710603", "01721815816", "01781335527"};
    String[] descriptionList = {"পদবি - ইন্সট্রাক্টর ও বিভাগীয় প্রধান", "পদবি - জুনিয়র ইন্সট্রাক্টর", "পদবি - জুনিয়র ইন্সট্রাক্টর", "পদবি - জুনিয়র ইন্সট্রাক্টর"};
    String[] thumbImageList = {""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Hotline> hotlineList = new ArrayList<>();
        for (int i = 0; i < nameList.length; i++) {
            hotlineList.add(new Hotline(nameList[i], numberList[i], descriptionList[i], ""));
        }

        mRecyclerView = findViewById(R.id.rcl_content);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        mRecyclerView.addItemDecoration(new EqualSpacingItemDecoration(20, EqualSpacingItemDecoration.GRID));
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new HotlineAdapter(hotlineList, this);
        mRecyclerView.setAdapter(mAdapter);
    }
}