package com.example.inniiis.hangang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Mypage2Activity extends AppCompatActivity {

    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;
    String res_120, river, facility, date, adult, baby;
    TextView textView;

    private ListView mypageListView;
    MypageListAdapter mMypageListAdapter = new MypageListAdapter();
    final ArrayList<Mypage> mypageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        mypageListView = (ListView) findViewById(R.id.mypageListView);
        mypageListView.setAdapter(mMypageListAdapter);

        river = ReservokActivity.areatest;
        facility = ReservokActivity.drusetest;
        date = ReservokActivity.datetest;
        adult = ReservokActivity.adulttest;
        baby = ReservokActivity.babytest;

//        mMypageListAdapter.addItem(river, facility, date, adult, baby);
//        mMypageListAdapter.notifyDataSetChanged();
    }

    @Override public void onBackPressed() {
        //super.onBackPressed();
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime)
        {
            super.onBackPressed();
        }
        else
        {
            backPressedTime = tempTime;
        }
    }
}
