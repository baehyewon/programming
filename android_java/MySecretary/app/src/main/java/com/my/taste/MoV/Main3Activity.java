package com.my.taste.MoV;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;


import com.my.taste.AddFriendActivity;
import com.my.taste.AlarmUtil;
import com.my.taste.DBConstants;
import com.my.taste.DBHelper;
import com.my.taste.Define;
import com.my.taste.FriendInfo;
import com.my.taste.FriendListViewItem;
import com.my.taste.R;
import com.my.taste.dap.FriendListViewAdapter3;

import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Main3Activity extends Activity implements View.OnClickListener{
    private String LOG_TAG = "Main3Activity";

    private long now = System.currentTimeMillis();
    private Date date = new Date(now);
    private SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String today1 = mFormat.format(date);

    private TextView txtResult;
    private Button /*btnLogout,*/ btnModify, btnDelete;
    private ImageButton btnAdd;

    private ScrollView mScrollView;
    private ListView mListView;

    private ArrayList<FriendListViewItem> mFriendArrayList;
    private FriendListViewAdapter3 mFriendListAdapter = null;
    private FriendListViewItem mSelItem = null;
    private int mSelAlarmId = 0;
    private List<FriendInfo> mFriendList = null;
    private int compare1 = 0;
    private DBHelper mDBHelper;

    private AlertDialog mDlg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mDBHelper = new DBHelper(this, DBConstants.DATABASE_NAME);
        //업무리스트바
        txtResult = findViewById(R.id.am_txt_result);
        String Nickname = getIntent().getStringExtra("nickname");
        txtResult.setText("" +Nickname + "님의 지연업무");
        txtResult.setTextColor(Color.parseColor("#ffffff"));

        //스크롤뷰뷰
        mScrollView = (ScrollView) findViewById(R.id.am2_scroll);
        mListView = (ListView)findViewById(R.id.am2_listview);
        mListView.setOnItemClickListener( new Main3Activity.ListViewItemClickListener() );
        mListView.setOnItemLongClickListener(new Main3Activity.ListViewItemLongClickListener());
        mListView.requestFocusFromTouch();
        mListView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                mScrollView.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        updateListView();
    }

    public void updateListView()
    {
        mFriendArrayList = new ArrayList<FriendListViewItem>();
        ArrayList<FriendListViewItem> mReOrderList = new ArrayList<FriendListViewItem>();
        mFriendListAdapter = new FriendListViewAdapter3(this, mFriendArrayList);
        mFriendList = mDBHelper.getFriendList();

        for(int i=0; i<mFriendList.size(); i++) {
            FriendInfo info = mFriendList.get(i);
            FriendListViewItem item = new FriendListViewItem();
            compare1 = today1.compareTo(mFriendList.get(i).getBirthday());

            if(mFriendList.get(i).getIsFinish().equals("F")&& compare1>=0){

                item.setId(info.getId());
                item.setIsHoney(info.getIsHoney());
                item.setIsFast(info.getIsFast());
                item.setIsFinish(info.getIsFinish());
                item.setIsFinish_2(info.getIsFinish_2());
                item.setName(info.getName());
                ////////////////////////////////////////////////////////////////////
                item.setBirthday(info.getBirthday());
                item.setBirthday_2(info.getBirthday_2());
                item.setWillGiveGift(info.getWillGiveGift());
                item.setWillGiveGift_2(info.getWillGiveGift_2());

                mFriendArrayList.add(item);
            }

        }

        Collections.sort(mFriendArrayList, myComparator);
        Collections.reverse(mFriendArrayList);

        mListView.setAdapter(mFriendListAdapter);
        mFriendListAdapter.notifyDataSetChanged();
    }

    //우위비교해서 주
    private Comparator<FriendListViewItem> myComparator = new Comparator<FriendListViewItem>() {
        private final Collator collator = Collator.getInstance();

        @Override
        public int compare(FriendListViewItem object1, FriendListViewItem object2) {
            return collator.compare(object1.getIsFast(), object2.getIsFast());
        }
    };

    private class ListViewItemClickListener implements AdapterView.OnItemClickListener
    {
        Intent intent = null;
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            mFriendListAdapter.setSelectedIndex(position);
            mFriendListAdapter.notifyDataSetChanged();

            mFriendList = mDBHelper.getFriendList();
            FriendInfo dbInfo = null;

            mSelItem = (FriendListViewItem) parent.getItemAtPosition(position);

            for(int i=0; i<mFriendList.size(); i++) {

                dbInfo = mFriendList.get(i);

                if(dbInfo.getName().equals(mSelItem.getName()))
                {
                    mSelAlarmId = Integer.parseInt(dbInfo.getAlarmId());
                    break;
                }
            }


            intent = new Intent(getApplicationContext(), AddFriendActivity.class);
            mFriendList = mDBHelper.getFriendList();
            FriendInfo modifyInfo = null;

            for(int i=0; i<mFriendList.size(); i++) {

                modifyInfo = mFriendList.get(i);

                if(modifyInfo.getName().equals(mSelItem.getName()))
                {
                    break;
                }
            }

            intent.putExtra(Define.INTENT_INFO_IS_MODIFY, true);
            intent.putExtra(Define.INTENT_INFO_IS_HONEY, modifyInfo.getIsHoney());
            intent.putExtra(Define.INTENT_INFO_NAME, modifyInfo.getName());
            intent.putExtra(Define.INTENT_INFO_PHONE, modifyInfo.getPhone());
            intent.putExtra(Define.INTENT_INFO_BIRTHDAY, modifyInfo.getBirthday());
            intent.putExtra(Define.INTENT_INFO_ALARM_DATE, modifyInfo.getAlarmDate());
            intent.putExtra(Define.INTENT_INFO_ALARM_HOUR, modifyInfo.getAlarmHour());
            intent.putExtra(Define.INTENT_INFO_ALARM_MINUTE, modifyInfo.getAlarmMinute());

            intent.putExtra(Define.INTENT_INFO_STYLE, modifyInfo.getStyle());
            intent.putExtra(Define.INTENT_INFO_LIKE, modifyInfo.getLike());

            intent.putExtra(Define.INTENT_INFO_PHONE_2, modifyInfo.getPhone_2());
            intent.putExtra(Define.INTENT_INFO_BIRTHDAY_2, modifyInfo.getBirthday_2());
            intent.putExtra(Define.INTENT_INFO_ALARM_DATE_2, modifyInfo.getAlarmDate_2());
            intent.putExtra(Define.INTENT_INFO_ALARM_HOUR_2, modifyInfo.getAlarmHour_2());
            intent.putExtra(Define.INTENT_INFO_ALARM_MINUTE_2, modifyInfo.getAlarmMinute_2());

            intent.putExtra(Define.INTENT_INFO_STYLE_2, modifyInfo.getStyle_2());
            intent.putExtra(Define.INTENT_INFO_LIKE_2, modifyInfo.getLike_2());

            intent.putExtra(Define.INTENT_INFO_WILL_GIVE_GIFT, modifyInfo.getWillGiveGift());
            intent.putExtra(Define.INTENT_INFO_WILL_GIVE_GIFT_2, modifyInfo.getWillGiveGift_2());
            intent.putExtra(Define.INTENT_INFO_MESSAGE, modifyInfo.getAlarmMsg());
            intent.putExtra(Define.INTENT_INFO_IS_FAST, modifyInfo.getIsFast());
            intent.putExtra(Define.INTENT_INFO_IS_FINISH, modifyInfo.getIsFinish());
            intent.putExtra(Define.INTENT_INFO_IS_FINISH_2, modifyInfo.getIsFinish_2());
            intent.putExtra(Define.INTENT_INFO_NOTICE, modifyInfo.getNotice());
            intent.putExtra(Define.INTENT_INFO_MESSAGE_2, modifyInfo.getAlarmMsg_2());
            startActivity(intent);

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == Define.INTENT_REQ_RECOMMEND) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //만약 반환값이 없을 경우의 코드를 여기에 작성하세요.
            }
        }
    }

    public void delFriendListDialog() {

        AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);

        alt_bld.setTitle("친구 삭제");
        alt_bld.setMessage("선택하신 친구를 DB에서 삭제하시겠습니까?.");

        alt_bld.setCancelable(false)
                .setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                        mDBHelper.deleteDB(mSelItem.getName());
                        AlarmUtil.unregisterAlarm(Main3Activity.this, mSelAlarmId);
                        updateListView();
                        mSelItem = null;
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

    @Override
    public void onClick(View view) {

        Intent intent = null;

        switch (view.getId())
        {
            case R.id.dlg_ok:

                break;

            /*
            case R.id.am_btn_logout:
                UserManagement.requestLogout(new LogoutResponseCallback() {
                    @Override
                    public void onCompleteLogout() {
                        redirectLoginActivity();
                    }
                });
                break;
                */

        }
    }

    private class ListViewItemLongClickListener implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            mFriendListAdapter.setSelectedIndex(position);
            mFriendListAdapter.notifyDataSetChanged();
            int a = 1;

            mFriendList = mDBHelper.getFriendList();
            FriendInfo dbInfo = null;

            mSelItem = (FriendListViewItem) parent.getItemAtPosition(position);

            for(int i=0; i<mFriendList.size(); i++) {

                dbInfo = mFriendList.get(i);

                if(dbInfo.getName().equals(mSelItem.getName()))
                {
                    mSelAlarmId = Integer.parseInt(dbInfo.getAlarmId());
                    break;
                }
            }

            delFriendListDialog();
            return true;
        }
    }
}
