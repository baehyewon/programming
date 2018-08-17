package com.my.taste;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.my.taste.MoV.Main2Activity;
import com.my.taste.MoV.Main3Activity;
import com.my.taste.MoV.Main4Activity;
import com.my.taste.MoV.Main55Activity;
import com.my.taste.MoV.Main66Activity;
import com.my.taste.MoV.Main77Activity;
import com.my.taste.MoV.MainActivity;

public class MonitorActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnAll, btnPro, btnDelay, btnFinish, btnCal;
    private ImageButton btnImportant, btnFast, btnToday, btnSearch;
    String Nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        Nickname = getIntent().getStringExtra("nickname");

        btnAll = (Button) findViewById(R.id.mo_btn_all);
        btnAll.setOnClickListener(this);
        btnPro = (Button)findViewById(R.id.mo_btn_process);
        btnPro.setOnClickListener(this);
        btnDelay = (Button) findViewById(R.id.mo_btn_delay);
        btnDelay.setOnClickListener(this);
        btnFinish = (Button) findViewById(R.id.mo_btn_finish);
        btnFinish.setOnClickListener(this);
        btnImportant = (ImageButton) findViewById(R.id.mo_important);
        btnImportant.setOnClickListener(this);
        btnFast = (ImageButton) findViewById(R.id.mo_fast);
        btnFast.setOnClickListener(this);
        btnToday = (ImageButton) findViewById(R.id.mo_today);
        btnToday.setOnClickListener(this);
        btnSearch = (ImageButton) findViewById(R.id.mo_search);
        btnSearch.setOnClickListener(this);
        //btnCal = (Button) findViewById(R.id.mo_btn_calendar);
        //btnCal.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void redirectLoginActivity() {
        final Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId())
        {
            case R.id.mo_btn_all:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra("nickname", Nickname);
                startActivity(intent);
                break;
            case R.id.mo_btn_process:
                intent = new Intent(this, Main2Activity.class);
                intent.putExtra("nickname", Nickname);
                startActivity(intent);
                break;
            case R.id.mo_btn_delay:
                intent = new Intent(this, Main3Activity.class);
                intent.putExtra("nickname", Nickname);
                startActivity(intent);
                break;
            case R.id.mo_btn_finish:
                intent = new Intent(this, Main4Activity.class);
                intent.putExtra("nickname", Nickname);
                startActivity(intent);
                break;
            case R.id.mo_important:
                intent = new Intent(this, Main55Activity.class);
                intent.putExtra("nickname", Nickname);
                startActivity(intent);
                break;
            case R.id.mo_fast:
                intent = new Intent(this, Main66Activity.class);
                intent.putExtra("nickname", Nickname);
                startActivity(intent);
                break;
            case R.id.mo_today:
                intent = new Intent(this, Main77Activity.class);
                intent.putExtra("nickname", Nickname);
                startActivity(intent);
                break;
            case R.id.mo_search:
                intent = new Intent(this, CaldroidSampleActivity.class);
                startActivity(intent);
                break;
                //intent = new Intent(this, Main4Activity.class);
                //startActivity(intent);
           // case R.id.mo_btn_calendar:
                //intent = new Intent(this, CaldroidSampleActivity.class);
                //startActivity(intent);
             //   break;
        }
    }
}
