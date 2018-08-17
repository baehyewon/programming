package com.example.inniiis.hangang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by inniiis on 2017-06-08.
 */

public class Reserv1Activity extends AppCompatActivity {
    int check;
    String use;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserv1);

        Intent intent = getIntent();
        check = intent.getIntExtra("check", 0);
//      Toast.makeText(this, check, Toast.LENGTH_SHORT).show();

        final ArrayList<String> items = new ArrayList<String>();
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, items);

        // listview 생성 및 adapter 지정.
        final ListView listview = (ListView) findViewById(R.id.area);
        listview.setAdapter(adapter);


        if (check == 1) {
            // 아이템 추가.
            items.add("여의도");
            items.add("난지");
            items.add("반포");
            // listview 갱신
            adapter.notifyDataSetChanged();

            use = "결혼식";
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id) {

                    // get TextView's Text.
                    String area = (String) parent.getItemAtPosition(position);
                    Intent intent = new Intent(Reserv1Activity.this, Reserv2Activity.class);
                    intent.putExtra("use", use);
                    intent.putExtra("area", area);
                    startActivity(intent);

                    // TODO : use strText
                }

            });
        }

        if (check == 2) {
            // 아이템 추가.
            items.add("난지");
            // listview 갱신
            adapter.notifyDataSetChanged();

            use = "난지캠핑장";
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id) {

                    // get TextView's Text.
                    String area = (String) parent.getItemAtPosition(position);
                    Intent intent = new Intent(Reserv1Activity.this, Reserv2Activity.class);
                    intent.putExtra("use", use);
                    intent.putExtra("area", area);
                    startActivity(intent);

                    // TODO : use strText
                }

            });
        }

        if (check == 3) {
            // 아이템 추가.
            items.add("광나루");
            // listview 갱신
            adapter.notifyDataSetChanged();

            use = "드론공원";
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id) {

                    // get TextView's Text.
                    String area = (String) parent.getItemAtPosition(position);
                    Intent intent = new Intent(Reserv1Activity.this, Reserv2Activity.class);
                    intent.putExtra("use", use);
                    intent.putExtra("area", area);
                    startActivity(intent);

                    // TODO : use strText
                }

            });
        }
        //난지 / 뚝섬 / 망원 / 반포 / 양화 / 여의도 / 잠실 / 잠원
        if (check == 4) {
            // 아이템 추가.
            items.add("광나루");
            items.add("난지");
            items.add("뚝섬");
            items.add("망원");
            items.add("반포");
            items.add("양화");
            items.add("여의도");
            items.add("잠실");
            items.add("잠원");

            // listview 갱신
            adapter.notifyDataSetChanged();

            use = "수영장";
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id) {

                    // get TextView's Text.
                    String area = (String) parent.getItemAtPosition(position);
                    Intent intent = new Intent(Reserv1Activity.this, Reserv2Activity.class);
                    intent.putExtra("use", use);
                    intent.putExtra("area", area);
                    startActivity(intent);

                    // TODO : use strText
                }

            });
        }
        if (check == 6) {
            // 아이템 추가.
            items.add("반포");
            // listview 갱신
            adapter.notifyDataSetChanged();

            use = "튜브스터";
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id) {

                    // get TextView's Text.
                    String area = (String) parent.getItemAtPosition(position);
                    Intent intent = new Intent(Reserv1Activity.this, Reserv2Activity.class);
                    intent.putExtra("use", use);
                    intent.putExtra("area", area);
                    startActivity(intent);

                    // TODO : use strText
                }

            });
        }
        if (check == 5) {
            // 아이템 추가.
            items.add("여의도");
            items.add("잠실");
            // listview 갱신
            adapter.notifyDataSetChanged();

            use = "유람선";
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id) {

                    // get TextView's Text.
                    String area = (String) parent.getItemAtPosition(position);
                    Intent intent = new Intent(Reserv1Activity.this, Reserv2Activity.class);
                    intent.putExtra("use", use);
                    intent.putExtra("area", area);
                    startActivity(intent);

                    // TODO : use strText
                }

            });
        }

        if (check == 7) {
            // 아이템 추가.
            items.add("반포");
            // listview 갱신
            adapter.notifyDataSetChanged();

            use = "푸드트럭";
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id) {

                    // get TextView's Text.
                    String area = (String) parent.getItemAtPosition(position);
                    Intent intent = new Intent(Reserv1Activity.this, Reserv2Activity.class);
                    intent.putExtra("use", use);
                    intent.putExtra("area", area);
                    startActivity(intent);

                    // TODO : use strText
                }

            });
        }
    }
}
