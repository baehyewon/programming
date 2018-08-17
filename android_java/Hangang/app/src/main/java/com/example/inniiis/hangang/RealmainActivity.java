package com.example.inniiis.hangang;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by inniiis on 2017-06-08.
 */

public class RealmainActivity extends AppCompatActivity {
    ViewPager viewPager;
    SwipeAdapter adapter;

    long now = System.currentTimeMillis();
    Date date = new Date(now);
    SimpleDateFormat sdfNow = new SimpleDateFormat("HH:mm");
    String formatDate = sdfNow.format(date);

    TextView dateNow;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realmain);

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        adapter = new SwipeAdapter(this);
        viewPager.setAdapter(adapter);

        TextView dateNow = (TextView) findViewById(R.id.clock);
        dateNow.setText(formatDate);
    }
}
