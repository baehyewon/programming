package com.my.taste;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import com.my.taste.dial.DirectSmsActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class AddFriendActivity extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private CheckBox chkIsHoney, chkIsFast, chkIsFinish, chkIsFinish_2;
    private EditText edtName, edtPhone, edtStyle, edtLike, edtPhone_2, edtStyle_2, edtLike_2, edtWillGiveGift, edtWillGiveGift_2, edtMessage, edtMessage_2, edtNotice;
    private DatePicker dateBirthday, dateAlarm, dateBirthday_2, dateAlarm_2;
    private TimePicker timeAlarm, timeAlarm_2;
    private AlertDialog mDlg = null;
    private Button btnAdd, btnBtnSearch, btnBtnSearch_2;
    private ImageButton btnDelete, btnEmail, btnEmail_2;
    private DBHelper mDBHelper;
    private boolean isModify = false;
    private Intent intent;

    public static final String SELECTED_NAME = "selectedname";
    public static final String SELECTED_PHONE = "selectedphone";
    public static final int SUCCESS = 1;

    private final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        checkPermission();

        mDBHelper = new DBHelper(this, DBConstants.DATABASE_NAME);

        edtName = findViewById(R.id.aaf_edt_name);
        edtPhone = findViewById(R.id.aaf_edt_phone);
        chkIsHoney = findViewById(R.id.aaf_chk_honey);
        chkIsFast = findViewById(R.id.aaf_chk_fast);
        chkIsFinish = findViewById(R.id.aaf_chk_finish);
        chkIsFinish_2 = findViewById(R.id.aaf_chk_finish_2);
        chkIsHoney.setOnCheckedChangeListener(this);
        chkIsFast.setOnCheckedChangeListener(this);
        edtStyle = findViewById(R.id.aaf_edt_style);
        edtLike = findViewById(R.id.aaf_edt_like);
        edtWillGiveGift = findViewById(R.id.aaf_edt_will_give_gift);
        edtWillGiveGift_2 = findViewById(R.id.aaf_edt_will_give_gift_2);
        edtPhone_2 = findViewById(R.id.aaf_edt_phone_2);
        edtStyle_2 = findViewById(R.id.aaf_edt_style_2);
        edtLike_2 = findViewById(R.id.aaf_edt_like_2);
        edtMessage = findViewById(R.id.aaf_edt_message);
        edtMessage_2 = findViewById(R.id.aaf_edt_message_2);
        edtNotice = findViewById(R.id.aaf_edt_notice);
        dateBirthday = findViewById(R.id.aaf_date_birthday);
        dateBirthday_2 = findViewById(R.id.aaf_date_birthday_2);

        dateBirthday.init(dateBirthday.getYear(), dateBirthday.getMonth(), dateBirthday.getDayOfMonth(),
            new DatePicker.OnDateChangedListener() {
                //값이 바뀔때마다 텍스트뷰의 값을 바꿔준다.
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    // TODO Auto-generated method stub
                    dateAlarm.init(year, monthOfYear, dayOfMonth - 7, null);
                }
        });

        dateBirthday_2.init(dateBirthday_2.getYear(), dateBirthday_2.getMonth(), dateBirthday_2.getDayOfMonth(),
                new DatePicker.OnDateChangedListener() {
                    //값이 바뀔때마다 텍스트뷰의 값을 바꿔준다.
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // TODO Auto-generated method stub
                        dateAlarm_2.init(year, monthOfYear, dayOfMonth - 7, null);
                    }
                });

        dateAlarm = findViewById(R.id.aaf_date_alarm);
        dateAlarm_2 = findViewById(R.id.aaf_date_alarm_2);

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        int year_2 = c.get(Calendar.YEAR);
        int month_2 = c.get(Calendar.MONTH);
        int day_2 = c.get(Calendar.DAY_OF_MONTH);

        //알람 날짜는 생일 3일전으로 맞춘다.
        dateAlarm.init(year_2, month_2, day_2-3, null);
        dateAlarm_2.init(year_2, month_2, day_2-3, null);
        timeAlarm = findViewById(R.id.aaf_time_alarm);
        timeAlarm_2 = findViewById(R.id.aaf_time_alarm_2);

        btnAdd = findViewById(R.id.aaf_btn_add);
        btnAdd.setOnClickListener(this);
        btnDelete = findViewById(R.id.delete_btn);
        btnDelete.setOnClickListener(this);

        btnBtnSearch = findViewById(R.id.aaf_btn_call);
        btnBtnSearch.setOnClickListener(this);

        btnBtnSearch_2 = findViewById(R.id.aaf_btn_call_2);
        btnBtnSearch_2.setOnClickListener(this);

        btnEmail = findViewById(R.id.aaf_btn_message);
        btnEmail_2 = findViewById(R.id.aaf_btn_message_2);
        btnEmail.setOnClickListener(this);
        btnEmail_2.setOnClickListener(this);
//
        isModify = getIntent().getBooleanExtra(Define.INTENT_INFO_IS_MODIFY, false);
        if(isModify == true)
        {
            btnAdd.setText("수정");
            String strIsHoney = getIntent().getStringExtra(Define.INTENT_INFO_IS_HONEY);
            String strName = getIntent().getStringExtra(Define.INTENT_INFO_NAME);
            String strPhone = getIntent().getStringExtra(Define.INTENT_INFO_PHONE);
            String strBirthday = getIntent().getStringExtra(Define.INTENT_INFO_BIRTHDAY);
            String strAlarmDate = getIntent().getStringExtra(Define.INTENT_INFO_ALARM_DATE);
            String strAlarmHour = getIntent().getStringExtra(Define.INTENT_INFO_ALARM_HOUR);
            String strAlarmMinute = getIntent().getStringExtra(Define.INTENT_INFO_ALARM_MINUTE);
            String strPhone_2 = getIntent().getStringExtra(Define.INTENT_INFO_PHONE_2);
            String strStyle = getIntent().getStringExtra(Define.INTENT_INFO_STYLE);
            String strLike = getIntent().getStringExtra(Define.INTENT_INFO_LIKE);
            String strBirthday_2 = getIntent().getStringExtra(Define.INTENT_INFO_BIRTHDAY_2);
            String strAlarmDate_2 = getIntent().getStringExtra(Define.INTENT_INFO_ALARM_DATE_2);
            String strAlarmHour_2 = getIntent().getStringExtra(Define.INTENT_INFO_ALARM_HOUR_2);
            String strAlarmMinute_2 = getIntent().getStringExtra(Define.INTENT_INFO_ALARM_MINUTE_2);
            String strStyle_2 = getIntent().getStringExtra(Define.INTENT_INFO_STYLE_2);
            String strLike_2 = getIntent().getStringExtra(Define.INTENT_INFO_LIKE_2);
            String strWillGiveGift = getIntent().getStringExtra(Define.INTENT_INFO_WILL_GIVE_GIFT);
            String strWillGiveGift_2 = getIntent().getStringExtra(Define.INTENT_INFO_WILL_GIVE_GIFT_2);
            String strMessage = getIntent().getStringExtra(Define.INTENT_INFO_MESSAGE);
            String strIsFast = getIntent().getStringExtra(Define.INTENT_INFO_IS_FAST);
            String strIsFinish = getIntent().getStringExtra(Define.INTENT_INFO_IS_FINISH);
            String strIsFinish_2 = getIntent().getStringExtra(Define.INTENT_INFO_IS_FINISH_2);
            String strMessage_2 = getIntent().getStringExtra(Define.INTENT_INFO_MESSAGE_2);
            String strNotice = getIntent().getStringExtra(Define.INTENT_INFO_NOTICE);

            boolean isHoney = false;
            if(strIsHoney.equals("T"))
                isHoney = true;
            else
                isHoney = false;
//
            boolean isFast = false;
            if(strIsFast.equals("T"))
                isFast = true;
            else
                isFast = false;
//
            boolean isFinish = false;
            if(strIsFinish.equals("T"))
                isFinish = true;
            else
                isFinish = false;


//
            boolean isFinish_2 = false;
            if(strIsFinish_2.equals("T"))
                isFinish_2 = true;
            else
                isFinish_2 = false;

            chkIsHoney.setChecked(isHoney);
            chkIsFast.setChecked(isFast);
            chkIsFinish.setChecked(isFinish);
            chkIsFinish_2.setChecked(isFinish_2);
            edtName.setText(strName);
            edtPhone.setText(strPhone);
            edtPhone_2.setText(strPhone_2);

//////////////////////////////////////////////////////////////////////////////////////
            String[] splitResult = strBirthday.split("-");
            String[] splitResult_2 = strBirthday_2.split("-");

            year = Integer.parseInt(splitResult[0]);
            month = Integer.parseInt(splitResult[1]);
            day = Integer.parseInt(splitResult[2]);
            dateBirthday.init(year, month-1, day, null);

            year_2 = Integer.parseInt(splitResult_2[0]);
            month_2 = Integer.parseInt(splitResult_2[1]);
            day_2 = Integer.parseInt(splitResult_2[2]);
            dateBirthday_2.init(year_2, month_2-1, day_2, null);

            splitResult = strAlarmDate.split("-");
            splitResult_2 = strAlarmDate_2.split("-");

            year = Integer.parseInt(splitResult[0]);
            month = Integer.parseInt(splitResult[1]);
            day = Integer.parseInt(splitResult[2]);
            dateAlarm.init(year, month-1, day, null);

            year_2 = Integer.parseInt(splitResult_2[0]);
            month_2 = Integer.parseInt(splitResult_2[1]);
            day_2 = Integer.parseInt(splitResult_2[2]);
            dateAlarm_2.init(year_2, month_2-1, day_2, null);

            int hour = Integer.parseInt(strAlarmHour);
            int minute = Integer.parseInt(strAlarmMinute);

            int hour_2 = Integer.parseInt(strAlarmHour_2);
            int minute_2 = Integer.parseInt(strAlarmMinute_2);

            timeAlarm.setHour(hour);
            timeAlarm.setMinute(minute);
            timeAlarm_2.setHour(hour_2);
            timeAlarm_2.setMinute(minute_2);

            edtStyle.setText(strStyle);
            edtLike.setText(strLike);
            edtStyle_2.setText(strStyle_2);
            edtLike_2.setText(strLike_2);
            edtNotice.setText(strNotice);

            edtWillGiveGift.setText(strWillGiveGift);
            edtWillGiveGift_2.setText(strWillGiveGift_2);
            edtMessage.setText(strMessage);
            edtMessage_2.setText(strMessage_2);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // 갤러리 사용권한에 대한 콜백을 받음
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // 권한 동의 버튼 선택
                }
                else {
                    // 사용자가 권한 동의를 안함
                    // 권한 동의안함 버튼 선택
                    Toast.makeText(AddFriendActivity.this, "권한사용을 동의해주셔야 이용이 가능합니다.", Toast.LENGTH_LONG).show();
                    finish();
                }
                return;
            }
        } // switch
    } // onRequestPermissionsResult

    private void checkPermission(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            // 권한 없을 경우
            // 최초 권한 요청인지, 혹은 사용자에 의한 재요청인지 확인
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)){
                // 사용자가 임의로 권한을 취소시킨 경우
                // 권한 재요청
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }
            else{
                // 최초로 권한을 요청하는 경우
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        }
        else {
            // 사용 권한 있음 확인
        }
    } // checkPermission

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10001) {
            if (resultCode == SUCCESS) {
                ((EditText)findViewById(R.id.aaf_edt_phone)).setText(data.getStringExtra(SELECTED_PHONE));
                ((EditText)findViewById(R.id.aaf_edt_style)).setText(data.getStringExtra(SELECTED_NAME));
                //((EditText)findViewById(R.id.aaf_edt_phone_2)).setText(data.getStringExtra(SELECTED_PHONE));
                //((EditText)findViewById(R.id.aaf_edt_style_2)).setText(data.getStringExtra(SELECTED_NAME));
            } else {
                ((EditText)findViewById(R.id.aaf_edt_phone)).setText("");
                ((EditText)findViewById(R.id.aaf_edt_style)).setText("");
                //((EditText)findViewById(R.id.aaf_edt_phone_2)).setText("");
                //((EditText)findViewById(R.id.aaf_edt_style_2)).setText("");
            }
        }
    }

    class LoadContactsAsync extends AsyncTask<Void, Void, ArrayList<String>> {
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(AddFriendActivity.this, "Loading Contacts", "Please wait");
        }

        @Override
        protected void onPostExecute(ArrayList<String> contacts) {
            super.onPostExecute(contacts);
            progressDialog.cancel();
            //linearlayout.removeView(btnAddressBook);
            //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.layout_phonelist, contacts);
            //adrssListView.setAdapter(adapter);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(ArrayList<String> strings) {
            super.onCancelled(strings);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected ArrayList<String> doInBackground(Void... params) {
            ArrayList<String> contacts = new ArrayList<String>();
            Cursor cursor = getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null
            );
            while(cursor.moveToNext()){
                String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contacts.add(contactName + ":" + phNumber);
            }
            cursor.close();
            return contacts;
        }
    }


    private void showContactlist() {
        Intent intent = new Intent(AddFriendActivity.this,
                ContactListActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        startActivityForResult(intent, 10001);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId())
        {
            case R.id.aaf_btn_add:
                String name = edtName.getText().toString();
                if(name.equals(""))
                {
                    Toast.makeText(this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                String phone = edtPhone.getText().toString();
                String phone_2 = edtPhone_2.getText().toString();
                String message = edtMessage.getText().toString();
                String message_2 = edtMessage_2.getText().toString();
                String will_given_gift = edtWillGiveGift.getText().toString();
                String will_given_gift_2 = edtWillGiveGift.getText().toString();
                //String notice = edtNotice.getText().toString();

                String birthday = String.format("%d-%d-%d", dateBirthday.getYear(), dateBirthday.getMonth() + 1, dateBirthday.getDayOfMonth());
                String alarm_date = String.format("%d-%d-%d", dateAlarm.getYear(), dateAlarm.getMonth() + 1, dateAlarm.getDayOfMonth());
                String alarm_hour = Integer.toString(timeAlarm.getCurrentHour());
                String alarm_minute = Integer.toString(timeAlarm.getCurrentMinute());

                String birthday_2 = String.format("%d-%d-%d", dateBirthday_2.getYear(), dateBirthday_2.getMonth() + 1, dateBirthday_2.getDayOfMonth());
                String alarm_date_2 = String.format("%d-%d-%d", dateAlarm_2.getYear(), dateAlarm_2.getMonth() + 1, dateAlarm_2.getDayOfMonth());
                String alarm_hour_2 = Integer.toString(timeAlarm_2.getCurrentHour());
                String alarm_minute_2 = Integer.toString(timeAlarm_2.getCurrentMinute());

                int AlarmId = 0;
                AlarmId = mDBHelper.getLastAlarmId();
                AlarmId++;

                int AlarmId_2 = 0;
                AlarmId_2 = mDBHelper.getLastAlarmId_2();
                AlarmId_2++;

                String isHoney = "F";
                if(chkIsHoney.isChecked() == true)
                    isHoney = "T";
                else
                    isHoney = "F";
                //////
                String isFast = "F";
                if(chkIsFast.isChecked() == true)
                    isFast = "T";
                else
                    isFast = "F";
                ////////
                String isFinish = "F";
                if(chkIsFinish.isChecked() == true)
                    isFinish = "T";
                else
                    isFinish = "F";
                ///////
                String isFinish_2 = "F";
                if(chkIsFinish_2.isChecked() == true)
                    isFinish_2 = "T";
                else
                    isFinish_2 = "F";

                //DB 수정하기 일경우
                //기존 DB는 삭제하고 새로 추가한다.
                if(isModify == true)
                {
                    mDBHelper.deleteDB(name);
                }

                int nResult = mDBHelper.insertDB(name, phone, isHoney, birthday, alarm_date, alarm_hour, alarm_minute, Integer.toString(AlarmId), edtStyle.getText().toString(), edtLike.getText().toString(),
                        edtWillGiveGift.getText().toString(), edtWillGiveGift_2.getText().toString(), message, phone_2, birthday_2, alarm_date_2, alarm_hour_2, alarm_minute_2, Integer.toString(AlarmId_2),
                        edtStyle_2.getText().toString(), edtLike_2.getText().toString(), isFast, isFinish, isFinish_2, edtNotice.getText().toString(), message_2);

                //DB등록이 성공일 경우 알람 설정한다.
                if(nResult == 1)
                {
                    AlarmUtil.setAlarm(this, AlarmId, name, phone, birthday, message, dateAlarm.getYear(), dateAlarm.getMonth(), dateAlarm.getDayOfMonth(), timeAlarm.getCurrentHour(), timeAlarm.getCurrentMinute(), will_given_gift);
                    AlarmUtil_2.setAlarm_2(this, AlarmId_2, name, phone_2, birthday_2, message_2,  dateAlarm_2.getYear(), dateAlarm_2.getMonth(), dateAlarm_2.getDayOfMonth(), timeAlarm_2.getCurrentHour(), timeAlarm_2.getCurrentMinute(), will_given_gift_2);
                    //AlarmUtil_3.setAlarm(this, AlarmId, name, phone, birthday, message, dateAlarm.getYear(), dateAlarm.getMonth(), dateAlarm.getDayOfMonth(), timeAlarm.getCurrentHour(), timeAlarm.getCurrentMinute(), will_given_gift);
                    Toast.makeText(this, "DB 등록 완료!", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else if(nResult == 100)
                {
                    Toast.makeText(this, "DB 등록 실패(이름 중복)!", Toast.LENGTH_SHORT).show();
                }
                else if(nResult == 0)
                {
                    Toast.makeText(this, "DB 등록 실패!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.delete_btn:
                //delFriendListDialog();
                break;

            case R.id.aaf_btn_message:
                String style = edtStyle.getText().toString();
                phone = edtPhone.getText().toString();
                message = edtMessage.getText().toString();
                intent = new Intent(getApplicationContext(), DirectSmsActivity.class);
                intent.putExtra("style", style);
                intent.putExtra("phone", phone);
                intent.putExtra("message", message);
                startActivity(intent);
                finish();
                break;
            case R.id.aaf_btn_message_2:
                String style2 = edtStyle_2.getText().toString();
                phone_2 = edtPhone_2.getText().toString();
                message_2 = edtMessage_2.getText().toString();
                intent = new Intent(getApplicationContext(), DirectSmsActivity.class);
                intent.putExtra("style", style2);
                intent.putExtra("phone", phone_2);
                intent.putExtra("message", message_2);
                startActivity(intent);
                finish();
                break;
            case R.id.aaf_btn_call:
                LoadContactsAsync loadContactsAsync = new LoadContactsAsync();
                loadContactsAsync.execute();
                showContactlist();
                break;
            case R.id.aaf_btn_call_2:
                LoadContactsAsync loadContactsAsync2 = new LoadContactsAsync();
                loadContactsAsync2.execute();
                showContactlist();



        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId())
        {
            case R.id.aaf_chk_honey:
                if (chkIsHoney.isChecked()) {
                    chkIsFast.setEnabled(false);
                }else{
                    chkIsFast.setEnabled(true);
                } break;

            case R.id.aaf_chk_fast:
                if (chkIsFast.isChecked()) {
                    chkIsHoney.setEnabled(false);
                }else{
                    chkIsHoney.setEnabled(true);
                }

        }

    }

}
