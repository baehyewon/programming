package com.example.inniiis.hangang;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class List2Activity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        TabHost tabHost = getTabHost();


        Intent intent1 = new Intent(this, NoticeActivity.class);
        TabSpec tabSpecTab1 = tabHost.newTabSpec("TAB1").setIndicator("공지");
        tabSpecTab1.setContent(intent1);
        tabHost.addTab(tabSpecTab1);
/*
        TabSpec tabSpecTab2 = tabHost.newTabSpec("TAB2").setIndicator("정보");
        tabSpecTab2.setContent(R.id.tab2);
        tabHost.addTab(tabSpecTab2);
*/
        Intent intent2 = new Intent(this, InfoActivity.class);
        TabSpec tabSpecTab2 = tabHost.newTabSpec("TAB2").setIndicator("정보");
        tabSpecTab2.setContent(intent2);
        tabHost.addTab(tabSpecTab2);

        /*TabSpec tabSpecTab3 = tabHost.newTabSpec("TAB3").setIndicator("메인");
        tabSpecTab3.setContent(R.id.tab3);
        tabHost.addTab(tabSpecTab3);*/
        Intent intent3 = new Intent(this, RealmainActivity.class);
        TabSpec tabSpecTab3 = tabHost.newTabSpec("TAB3").setIndicator("메인");
        tabSpecTab3.setContent(intent3);
        tabHost.addTab(tabSpecTab3);

        /*TabSpec tabSpecTab4 = tabHost.newTabSpec("TAB4").setIndicator("예약");
        tabSpecTab4.setContent(R.id.tab4);
        tabHost.addTab(tabSpecTab4);*/

        //Intent intent4 = new Intent(this, Picture2Activity.class);
        Intent intent4 = new Intent(this, Picture2Activity.class);
        TabSpec tabSpecTab4 = tabHost.newTabSpec("TAB4").setIndicator("예약");
        tabSpecTab4.setContent(intent4);
        tabHost.addTab(tabSpecTab4);

        /*TabSpec tabSpecTab5 = tabHost.newTabSpec("TAB5").setIndicator("서울시");
        tabSpecTab5.setContent(R.id.tab5);
        tabHost.addTab(tabSpecTab5);*/
//Picture2Activity
        Intent intent5 = new Intent(this, Picture2Activity.class);
        TabSpec tabSpecTab5 = tabHost.newTabSpec("TAB5").setIndicator("My");
        tabSpecTab5.setContent(intent5);
        tabHost.addTab(tabSpecTab5);

        tabHost.setCurrentTab(2);

    }
}
