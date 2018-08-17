package com.example.inniiis.hangang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by inniiis on 2017-06-08.
 */

public class S1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s1);

        ImageView image = (ImageView) findViewById(R.id.image_view);
        image.setImageResource(R.drawable.s1);

    }
}
