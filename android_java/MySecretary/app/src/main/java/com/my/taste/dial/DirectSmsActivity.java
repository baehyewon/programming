package com.my.taste.dial;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.my.taste.R;


public class DirectSmsActivity extends Activity implements View.OnClickListener{

    private EditText edtName, edtPhone, edtSms;
    private Button btnCancel;
    //private Button btnSend;

    private String intentName = "";
    private String intentPhone = "";
    private String intentSms = "";

    private String phone;
    private String message;

    private int intentAlarmId = 0;

    private AlertDialog mDlg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        edtName = (EditText) findViewById(R.id.as_edt_name);
        edtPhone = (EditText) findViewById(R.id.as_edt_phone);
        edtSms = (EditText) findViewById(R.id.as_edt_sms);

        //btnSend = (Button) findViewById(R.id.as_btn_send);
        //btnSend.setOnClickListener(this);

        btnCancel = (Button) findViewById(R.id.as_btn_cancel);
        btnCancel.setOnClickListener(this);

        Intent intent = getIntent();
        String style = intent.getStringExtra("style");
        edtName.setText(style);
        String phone = intent.getStringExtra("phone");
        edtPhone.setText(phone);
        String message = intent.getStringExtra("message");
        edtSms.setText(message);

        if(message.isEmpty()){
            edtSms.setText("금일 중 업무 보고 드리겠습니다.");
        }

        //intentName = getIntent().getStringExtra("name");
        //intentPhone = getIntent().getStringExtra("phone");
        //intentSms = getIntent().getStringExtra("message");

       // if(intentName != null)
        //    edtName.setText(intentName);

      //  if(intentPhone != null)
       //     edtPhone.setText(intentPhone);

       // if(intentSms != null)
         //   edtSms.setText(intentSms);
        //intentAlarmId = getIntent().getIntExtra("alarmId", 0);
        //AlarmUtil_3.unregisterSms(this, intentAlarmId);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void sendSMS(View v) {
        String smsNum = this.edtPhone.getText().toString();
        String smsText = this.edtSms.getText().toString();
        if(smsNum.length() > 0 && smsText.length() > 0) {
            this.sendSMS(smsNum, smsText);
        } else {
            Toast.makeText(this, "모두 입력해 주세요", Toast.LENGTH_SHORT).show();
        }
    }

    public void sendSMS(String smsNumber, String smsText) {
        PendingIntent sentIntent = PendingIntent.getBroadcast(this, 0, new Intent("SMS_SENT_ACTION"), 0);
        PendingIntent deliveredIntent = PendingIntent.getBroadcast(this, 0, new Intent("SMS_DELIVERED_ACTION"), 0);
        this.registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                switch(this.getResultCode()) {
                    case -1:
                        Toast.makeText(DirectSmsActivity.this, "전송 완료", Toast.LENGTH_SHORT).show();
                    case 0:
                    default:
                        break;
                    case 1:
                        Toast.makeText(DirectSmsActivity.this, "전송 실패", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(DirectSmsActivity.this, "무선(Radio)가 꺼져있습니다", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(DirectSmsActivity.this, "PDU Null", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(DirectSmsActivity.this, "서비스 지역이 아닙니다", Toast.LENGTH_SHORT).show();
                }

            }
        }, new IntentFilter("SMS_SENT_ACTION"));
        this.registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                switch(this.getResultCode()) {
                    case -1:
                        Toast.makeText(DirectSmsActivity.this, "SMS 도착 완료", Toast.LENGTH_SHORT).show();
                        break;
                    case 0:
                        Toast.makeText(DirectSmsActivity.this, "SMS 도착 실패", Toast.LENGTH_SHORT).show();
                }

            }
        }, new IntentFilter("SMS_DELIVERED_ACTION"));
        SmsManager mSmsManager = SmsManager.getDefault();
        mSmsManager.sendTextMessage(smsNumber, (String)null, smsText, sentIntent, deliveredIntent);
        finish();
    }
    //////////////////////////////////////

    public void cancelSendSmsDialog() {

        AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);

        alt_bld.setTitle("전송 취소");
        alt_bld.setMessage("SMS 메시지 전송을 취소 하시겠습니까?.");

        alt_bld.setCancelable(false)
                .setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                        finish();
                    }
                })
                .setNegativeButton("아니오", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // Action for 'NO' Button
                        dialog.cancel();
                    }
                });

        // 에러 메시지 다이아로그를 화면에 출력한다.
        mDlg = alt_bld.create();
        mDlg.show();
    }


    ///////////////////////////////
    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            /*case R.id.as_btn_send:
                sendSMS(phone, message);
                break;
*/
            case R.id.as_btn_cancel:
                cancelSendSmsDialog();
                break;
        }
    }
}
