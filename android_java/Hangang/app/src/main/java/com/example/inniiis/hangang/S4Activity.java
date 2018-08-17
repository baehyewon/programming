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

public class S4Activity extends AppCompatActivity {
    int test;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s4);

        ImageView image = (ImageView) findViewById(R.id.image_view);
        image.setImageResource(R.drawable.s4);

        //낚시 수상스포츠 수영장 테니스장
        ImageButton fish = (ImageButton) findViewById(R.id.s1);
        fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 0401;
                Intent intent = new Intent(S4Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });

        ImageButton sports = (ImageButton) findViewById(R.id.s2);
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 0402;
                Intent intent = new Intent(S4Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });

        ImageButton swim = (ImageButton) findViewById(R.id.s3);
        swim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 0403;
                Intent intent = new Intent(S4Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });
        ImageButton tenis = (ImageButton) findViewById(R.id.s4);
        tenis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 0404;
                Intent intent = new Intent(S4Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });
    }

}
