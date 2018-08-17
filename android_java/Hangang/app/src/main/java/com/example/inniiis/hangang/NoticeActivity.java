package com.example.inniiis.hangang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NoticeActivity extends AppCompatActivity {

    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;
    String res_120, title, writer, date;
    int check;

    private ListView noticeListView;
    NoticeListAdapter mNoticeListAdapter = new NoticeListAdapter();
   // final ArrayList<Notice> noticeList = new ArrayList<>();
    //private NoticeListAdapter adapter;
    //private List<Notice> noticeList;

    private TextView test;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        noticeListView = (ListView) findViewById(R.id.listView);
        noticeListView.setAdapter(mNoticeListAdapter);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://13.124.128.229:3100/notice")
                .build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                finish();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String responseData = response.body().string();
                Log.v("BK-201 URL: ", responseData);


                // wanna save the result to update UI

                JSONObject Jobject = null;


                try {
                    Jobject = new JSONObject(responseData);
                    JSONObject Result = new JSONObject(responseData);
                    String result = Jobject.getString("result");
                    JSONArray ResultArray = Result.getJSONArray("result");

                    for (int i = 0; i < ResultArray.length(); i++) {
                        JSONObject c = ResultArray.getJSONObject(i);
                        title = c.getString("title");
                        writer = c.getString("writer");
                        date = c.getString("notice_date");

                    }
                    mNoticeListAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        noticeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

            //    Object vo = (Object) parent.getAdapter().getItem(position);
                number = String.valueOf(position + 1);
                // get TextView's Text.
                Intent intent = new Intent(NoticeActivity.this, NoticedetailActivity.class);
                intent.putExtra("number", number);
                startActivity(intent);

                // TODO : use strText
            }

        });
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