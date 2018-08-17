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

public class S6Activity extends AppCompatActivity {
    int test;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s6);

        ImageView image = (ImageView) findViewById(R.id.image_view);
        image.setImageResource(R.drawable.s6);

        //인라인 테니스장
        ImageButton inline = (ImageButton) findViewById(R.id.s1);
        inline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 0601;
                Intent intent = new Intent(S6Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });

        ImageButton tenis = (ImageButton) findViewById(R.id.s2);
        tenis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 0602;
                Intent intent = new Intent(S6Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });

        ImageButton sports = (ImageButton) findViewById(R.id.s3);
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 0603;
                Intent intent = new Intent(S6Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });

    }

}
