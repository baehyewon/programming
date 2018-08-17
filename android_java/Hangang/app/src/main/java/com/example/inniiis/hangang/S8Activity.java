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

public class S8Activity extends AppCompatActivity {
    int test;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s8);

        ImageView image = (ImageView) findViewById(R.id.image_view);
        image.setImageResource(R.drawable.s8);

        //스포츠 수영장 테니스장
        ImageButton sports = (ImageButton) findViewById(R.id.s1);
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 81;
                Intent intent = new Intent(S8Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });

        ImageButton swim = (ImageButton) findViewById(R.id.s2);
        swim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 82;
                Intent intent = new Intent(S8Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });

        ImageButton bridge = (ImageButton) findViewById(R.id.s3);
        bridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 83;
                Intent intent = new Intent(S8Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });

    }

}
