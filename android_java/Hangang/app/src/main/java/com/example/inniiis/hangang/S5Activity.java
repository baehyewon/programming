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

public class S5Activity extends AppCompatActivity {
    int test;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s5);

        ImageView image = (ImageView) findViewById(R.id.image_view);
        image.setImageResource(R.drawable.s5);

        //물빛무대 빛의카페 수상스포츠 수영장 유람선
        ImageButton stage = (ImageButton) findViewById(R.id.s1);
        stage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 0501;
                Intent intent = new Intent(S5Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });

        ImageButton cafe = (ImageButton) findViewById(R.id.s2);
        cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 0502;
                Intent intent = new Intent(S5Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });

        ImageButton sports = (ImageButton) findViewById(R.id.s3);
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 0503;
                Intent intent = new Intent(S5Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });
        ImageButton swim = (ImageButton) findViewById(R.id.s4);
        swim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 0504;
                Intent intent = new Intent(S5Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });
        ImageButton ship = (ImageButton) findViewById(R.id.s5);
        ship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 0505;
                Intent intent = new Intent(S5Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });

    }

}
