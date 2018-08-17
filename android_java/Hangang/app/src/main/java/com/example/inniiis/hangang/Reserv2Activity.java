package com.example.inniiis.hangang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by inniiis on 2017-06-08.
 */

public class Reserv2Activity extends AppCompatActivity {
    String use, area, msg, stradult, strbaby, test;
    int adult;
    int baby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setWindowAnimations(0);
        setContentView(R.layout.activity_reserv2);

        use = getIntent().getStringExtra("use");
        area = getIntent().getStringExtra("area");
     //   Toast.makeText(this, use + "//" + area, Toast.LENGTH_LONG).show();

        TextView etuse = (TextView) findViewById(R.id.use);
        etuse.setText(use);
        TextView etarea = (TextView) findViewById(R.id.area);
        etarea.setText(area);

        Intent intent = getIntent();
        int check = intent.getIntExtra("check", 1);
        adult = intent.getIntExtra("adult", 00);
        baby = intent.getIntExtra("baby", 00);

        TextView person = (TextView) findViewById(R.id.person);
        if (check == 0) {
            String result = "대인 : " + adult + "명, 소인 : " + baby + "명  ";
            person.setText(result);
        }

        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {

            @Override //날짜를 받아와 토스트로 뿌려줌
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                msg = String.format("%d%d%d", year, monthOfYear + 1, dayOfMonth);
                Toast.makeText(Reserv2Activity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        Button people = (Button) findViewById(R.id.people);
        people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent popup = new Intent(Reserv2Activity.this, PopupActivity.class);
                startActivityForResult(popup, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK) {
            Toast.makeText(Reserv2Activity.this, "인원을 다시 선택해주세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (requestCode == 1) {
            int check = data.getIntExtra("check", 1);
            adult = data.getIntExtra("adult", 00);
            baby = data.getIntExtra("baby", 00);

            TextView person = (TextView) findViewById(R.id.person);
            if (check == 0) {
                String result = "대인 : " + adult + "명, 소인 : " + baby + "명  ";
                person.setText(result);
            }

            stradult = String.valueOf(adult);
            strbaby = String.valueOf(baby);

            Button ok = (Button) findViewById(R.id.ok);
            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Reserv2Activity.this, ReservokActivity.class);
                    intent.putExtra("use",use);
                    intent.putExtra("area",area);
                    intent.putExtra("date",msg);
                    intent.putExtra("adult",stradult);
                    intent.putExtra("baby",strbaby);
                    startActivity(intent);
                }
            });
        }
    }
}