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

public class S11Activity extends AppCompatActivity {
    int test;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s11);

        ImageView image = (ImageView) findViewById(R.id.image_view);

        ImageButton stage = (ImageButton) findViewById(R.id.s1);
        stage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 111;
                Intent intent = new Intent(S11Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });

        ImageButton cafe = (ImageButton) findViewById(R.id.s2);
        cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 112;
                Intent intent = new Intent(S11Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });

        ImageButton sports = (ImageButton) findViewById(R.id.s3);
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 113;
                Intent intent = new Intent(S11Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });
        ImageButton swim = (ImageButton) findViewById(R.id.s4);
        swim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 114;
                Intent intent = new Intent(S11Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });
        ImageButton ship = (ImageButton) findViewById(R.id.s5);
        ship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 115;
                Intent intent = new Intent(S11Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });

    }

}
