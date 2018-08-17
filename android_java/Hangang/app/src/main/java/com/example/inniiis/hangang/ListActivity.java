package com.example.inniiis.hangang;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class ListActivity extends TabActivity {
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        id = getIntent().getStringExtra("id");
        TabHost tabHost = getTabHost();


        Intent intent1 = new Intent(this, NoticeActivity.class);
        TabSpec tabSpecTab1 = tabHost.newTabSpec("TAB1").setIndicator("공지");
        tabSpecTab1.setContent(intent1);
        tabHost.addTab(tabSpecTab1);

        Intent intent2 = new Intent(this, InfoActivity.class);
        TabSpec tabSpecTab2 = tabHost.newTabSpec("TAB2").setIndicator("정보");
        tabSpecTab2.setContent(intent2);
        tabHost.addTab(tabSpecTab2);

        Intent intent3 = new Intent(this, RealmainActivity.class);
        TabSpec tabSpecTab3 = tabHost.newTabSpec("TAB3").setIndicator("메인");
        tabSpecTab3.setContent(intent3);
        tabHost.addTab(tabSpecTab3);

        Intent intent4 = new Intent(this, Picture3Activity.class);
        intent4.putExtra("id", id);
        TabSpec tabSpecTab4 = tabHost.newTabSpec("TAB4").setIndicator("예약");
        tabSpecTab4.setContent(intent4);
        tabHost.addTab(tabSpecTab4);

        Intent intent5 = new Intent(this, Mypage2Activity.class);
        TabSpec tabSpecTab5 = tabHost.newTabSpec("TAB5").setIndicator("My");
        tabSpecTab5.setContent(intent5);
        tabHost.addTab(tabSpecTab5);

        tabHost.setCurrentTab(2);

    }
}
