package com.example.inniiis.hangang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ReservActivity extends AppCompatActivity {
    static final String[] LIST_MENU = {"결혼식", "난지캠핑장", "드론공원", "수영장", "유람선", "튜브스터", "푸드트럭"};
    int check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserv);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, LIST_MENU);

        ListView listview = (ListView) findViewById(R.id.use);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get TextView's Text.
                String strText = (String) parent.getItemAtPosition(position) ;

                if(strText == "결혼식"){
                    check = 1;
                    Intent intent = new Intent(ReservActivity.this, Reserv1Activity.class);
                    intent.putExtra("check", check);
                    startActivity(intent);
                }
                if(strText == "난지캠핑장"){
                    check = 2;
                    Intent intent = new Intent(ReservActivity.this, Reserv1Activity.class);
                    intent.putExtra("check", check);
                    startActivity(intent);
                }

                if(strText == "드론공원"){
                    check = 3;
                    Intent intent = new Intent(ReservActivity.this, Reserv1Activity.class);
                    intent.putExtra("check", check);
                    startActivity(intent);
                }

                if(strText == "수영장"){
                    check = 4;
                    Intent intent = new Intent(ReservActivity.this, Reserv1Activity.class);
                    intent.putExtra("check", check);
                    startActivity(intent);
                }

                if(strText == "유람선"){
                    check = 5;
                    Intent intent = new Intent(ReservActivity.this, Reserv1Activity.class);
                    intent.putExtra("check", check);
                    startActivity(intent);
                }

                if(strText == "튜브스터"){
                    check = 6;
                    Intent intent = new Intent(ReservActivity.this, Reserv1Activity.class);
                    intent.putExtra("check", check);
                    startActivity(intent);
                }

                if(strText == "푸드트럭"){
                    check = 7;
                    Intent intent = new Intent(ReservActivity.this, Reserv1Activity.class);
                    intent.putExtra("check", check);
                    startActivity(intent);
                }
                // TODO : use strText
            }

        }) ;
    }

}
