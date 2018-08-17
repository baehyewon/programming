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

public class S10Activity extends AppCompatActivity {
    int test;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s10);

        ImageView image = (ImageView) findViewById(R.id.image_view);
        image.setImageResource(R.drawable.s10);

        //수상스포츠 수영장 유람선
        ImageButton inline = (ImageButton) findViewById(R.id.s1);
        inline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 101;
                Intent intent = new Intent(S10Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });

        ImageButton tenis = (ImageButton) findViewById(R.id.s2);
        tenis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 102;
                Intent intent = new Intent(S10Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });

        ImageButton ship = (ImageButton) findViewById(R.id.s3);
        ship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test = 103;
                Intent intent = new Intent(S10Activity.this, PictureActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });
    }

}
