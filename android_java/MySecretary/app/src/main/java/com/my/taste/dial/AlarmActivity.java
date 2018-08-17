package com.my.taste.dial;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.my.taste.AlarmUtil;
import com.my.taste.R;


public class AlarmActivity extends Activity implements View.OnClickListener{

    private TextView txtMessage;
    private Dialog DlgManager = null;

    private Button btnOk;

    private int intentAlarmId = 0;
    private String intentName = "";
    private String intentPhone = "";
    private String intentBirthday = "";
    private String intentMessage = "";
    private String intentWill = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_alarm);
        //setContentView(R.layout.activity_alarm);

        txtMessage = (TextView) findViewById(R.id.aa_txt_message);

        btnOk = (Button)findViewById(R.id.aa_btn_ok);
        btnOk.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        if(intent != null)
        {
            intentAlarmId = intent.getIntExtra("alarmId", 0);
            intentName = intent.getStringExtra("name");
            intentPhone = intent.getStringExtra("phone");
            intentBirthday = intent.getStringExtra("birthday");
            intentMessage = intent.getStringExtra("message");
            intentWill = intent.getStringExtra("will_given_gift");
            String AlarmMsg = "";

            AlarmMsg = "";


            if(intentName!= null)
                AlarmMsg = intentName + "의\n";
            if (intentWill != null)
                AlarmMsg += intentWill + "가\n";
            if(intentBirthday != null)
                AlarmMsg += intentBirthday + " 입니다!.\n오늘도 화이팅!!";

            txtMessage.setText(AlarmMsg);

            Vibrator vibrator;
            vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(2000);

            AlarmUtil.unregisterAlarm(this, intentAlarmId);
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.aa_btn_ok:
                finish();
                break;
/*
                String[] splitResult = intentBirthday.split("-");

                int year = Integer.parseInt(splitResult[0]);
                int month = Integer.parseInt(splitResult[1]);
                int day = Integer.parseInt(splitResult[2]);

                AlarmUtil.setSms(this, intentAlarmId, intentName, intentPhone, intentMessage, year, month-1, day, intentWill);
*/
                /*
                Intent intent = new Intent(this, SmsActivity.class);
                intent.putExtra("name", intentName);
                intent.putExtra("phone", intentPhone);
                intent.putExtra("message", intentMessage);
                startActivity(intent);
                */
        }
    }
}
