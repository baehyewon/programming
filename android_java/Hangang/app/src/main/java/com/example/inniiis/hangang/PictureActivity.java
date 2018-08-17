package com.example.inniiis.hangang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by inniiis on 2017-06-08.
 */

public class PictureActivity extends AppCompatActivity {
    String str;
    int test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        Intent intent = getIntent();
        String infocheck = intent.getStringExtra("infocheck");
        test = intent.getIntExtra("test", 0);

        ImageView info = (ImageView) findViewById(R.id.infoimage);

        //난지
        if (test == 0201) {
            info.setImageResource(R.drawable.ngswim);
        }
        if (test == 0202) {
            info.setImageResource(R.drawable.ngcycle);
        }
        if (test == 0203) {
            info.setImageResource(R.drawable.ngcamp);
        }
        //양화
        if (test == 0301) {
            info.setImageResource(R.drawable.yhsports);
        }
        if (test == 0302) {
            info.setImageResource(R.drawable.ngswim);
        }
        if (test == 0303) {
            info.setImageResource(R.drawable.yhbridge);
        }
        //망원
        if (test == 0401) {
            info.setImageResource(R.drawable.mwfish);
        }
        if (test == 0402) {
            info.setImageResource(R.drawable.mwsports);
        }
        if (test == 0403) {
            info.setImageResource(R.drawable.mwswim);
        }
        if (test == 0404) {
            info.setImageResource(R.drawable.mwtenis);
        }
        //여의도
        if (test == 0501) {
            info.setImageResource(R.drawable.yudstage);
        }
        if (test == 0502) {
            info.setImageResource(R.drawable.yudcafe);
        }
        if (test == 0503) {
            info.setImageResource(R.drawable.yudsports);
        }
        if (test == 0504) {
            info.setImageResource(R.drawable.mwswim);
        }
        if (test == 0505) {
            info.setImageResource(R.drawable.yudship);
        }
        //이촌
        if (test == 0601) {
            info.setImageResource(R.drawable.icsports);
        }
        if (test == 0602) {
            info.setImageResource(R.drawable.inline);
        }
        if (test == 0603) {
            info.setImageResource(R.drawable.ictenis);
        }
        //
        if (test == 0701) {
            info.setImageResource(R.drawable.west);
        }
        if (test == 0702) {
            info.setImageResource(R.drawable.threelight);
        }
        if (test == 0703) {
            info.setImageResource(R.drawable.bpsports);
        }
        if (test == 81) {
            info.setImageResource(R.drawable.jwsports);
        }
        if (test == 82) {
            info.setImageResource(R.drawable.mwswim);
        }
        if (test == 83) {
            info.setImageResource(R.drawable.jwtenis);
        }
        if (test == 91) {
            info.setImageResource(R.drawable.dssnow);
        }
        if (test == 92) {
            info.setImageResource(R.drawable.dssports);
        }
        if (test == 93) {
            info.setImageResource(R.drawable.mwswim);
        }
        if (test == 94) {
            info.setImageResource(R.drawable.dstenis);
        }
        if (test == 101) {
            info.setImageResource(R.drawable.jssports);
        }
        if (test == 102) {
            info.setImageResource(R.drawable.mwswim);
        }
        if (test == 103) {
            info.setImageResource(R.drawable.jsship);
        }
        //광나루
        if (test == 111) {
            info.setImageResource(R.drawable.dron);
        }
        if (test == 112) {
            info.setImageResource(R.drawable.park);
        }
        if (test == 113) {
            info.setImageResource(R.drawable.mwswim);
        }
        if (test == 114) {
            info.setImageResource(R.drawable.gnrcycle);
        }
        if (test == 115) {
            info.setImageResource(R.drawable.gnrtenis);
        }
    }

}
