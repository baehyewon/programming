package com.example.inniiis.hangang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by inniiis on 2017-06-08.
 */

public class InfoActivity extends AppCompatActivity {
    int infocheck;
    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ImageButton one = (ImageButton) findViewById(R.id.gs);
        ImageButton two = (ImageButton) findViewById(R.id.ng);
        ImageButton three = (ImageButton) findViewById(R.id.yh);
        ImageButton four = (ImageButton) findViewById(R.id.mw);
        ImageButton five = (ImageButton) findViewById(R.id.yud);
        ImageButton six = (ImageButton) findViewById(R.id.ic);
        ImageButton seven = (ImageButton) findViewById(R.id.bp);
        ImageButton eight = (ImageButton) findViewById(R.id.jw);
        ImageButton nine = (ImageButton) findViewById(R.id.ds);
        ImageButton ten = (ImageButton) findViewById(R.id.js);
        ImageButton eleven = (ImageButton) findViewById(R.id.gnr);
        ImageButton cancle = (ImageButton) findViewById(R.id.cancle);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infocheck = 1;
                Intent intent = new Intent(InfoActivity.this, DtinfoActivity.class);
                intent.putExtra("infocheck", infocheck);
                startActivity(intent);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infocheck = 2;
                Intent intent = new Intent(InfoActivity.this, DtinfoActivity.class);
                intent.putExtra("infocheck", infocheck);
                startActivity(intent);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infocheck = 3;
                Intent intent = new Intent(InfoActivity.this, DtinfoActivity.class);
                intent.putExtra("infocheck", infocheck);
                startActivity(intent);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infocheck = 4;
                Intent intent = new Intent(InfoActivity.this, DtinfoActivity.class);
                intent.putExtra("infocheck", infocheck);
                startActivity(intent);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infocheck = 5;
                Intent intent = new Intent(InfoActivity.this, DtinfoActivity.class);
                intent.putExtra("infocheck", infocheck);
                startActivity(intent);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infocheck = 6;
                Intent intent = new Intent(InfoActivity.this, DtinfoActivity.class);
                intent.putExtra("infocheck", infocheck);
                startActivity(intent);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infocheck = 7;
                Intent intent = new Intent(InfoActivity.this, DtinfoActivity.class);
                intent.putExtra("infocheck", infocheck);
                startActivity(intent);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infocheck = 8;
                Intent intent = new Intent(InfoActivity.this, DtinfoActivity.class);
                intent.putExtra("infocheck", infocheck);
                startActivity(intent);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infocheck = 9;
                Intent intent = new Intent(InfoActivity.this, DtinfoActivity.class);
                intent.putExtra("infocheck", infocheck);
                startActivity(intent);
            }
        });

        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infocheck = 10;
                Intent intent = new Intent(InfoActivity.this, DtinfoActivity.class);
                intent.putExtra("infocheck", infocheck);
                startActivity(intent);
            }
        });

        eleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infocheck = 11;
                Intent intent = new Intent(InfoActivity.this, DtinfoActivity.class);
                intent.putExtra("infocheck", infocheck);
                startActivity(intent);
            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
            }
        });

    }
    @Override public void onBackPressed() {
        //super.onBackPressed();
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime)
        {
            super.onBackPressed();
        }
        else
        {
            backPressedTime = tempTime;
        }
        }
}
