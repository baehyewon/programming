package com.example.inniiis.hangang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by inniiis on 2017-06-08.
 */

public class S9Activity extends AppCompatActivity {
    int test;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s9);

        ImageView image = (ImageView) findViewById(R.id.image_view);
        image.setImageResource(R.drawable.s9);

        //눈썰매장 수상스포츠 수영장 테니스장
        ImageButton fish = (ImageButton) findViewById(R.id.s1);
        fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 91;
                Intent intent = new Intent(S9Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });

        ImageButton sports = (ImageButton) findViewById(R.id.s2);
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 92;
                Intent intent = new Intent(S9Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });

        ImageButton swim = (ImageButton) findViewById(R.id.s3);
        swim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 93;
                Intent intent = new Intent(S9Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });
        ImageButton tenis = (ImageButton) findViewById(R.id.s4);
        tenis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 94;
                Intent intent = new Intent(S9Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });


    }

}
