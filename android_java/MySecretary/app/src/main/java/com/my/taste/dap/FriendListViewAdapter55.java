package com.my.taste.dap;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.my.taste.DBConstants;
import com.my.taste.DBHelper;
import com.my.taste.FriendListViewItem;
import com.my.taste.R;

import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class FriendListViewAdapter55 extends BaseAdapter /*implements CompoundButton.OnCheckedChangeListener*/ /*View.OnClickListener*/{

    //현재날짜 가져오기
    private long now = System.currentTimeMillis();
    private Date date = new Date(now);
    private String date1;
    private String date2;

    private int compare = 0;
    private int compare1 = 0;
    private int compare2 = 0;

    private SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String today = mFormat.format(date);


    private ArrayList<FriendListViewItem> FriendArrayList = null;
    private ListViewHolder viewHolder = null;
    private Context mContext = null;
    private LayoutInflater inflater = null;
    //리스트에서 선택한 Position
    private int mSelectedPosition = -1;

    private int mPos = 0;

    private DBHelper mDBHelper;

    private class ListViewHolder {

        //ID(인덱스)
//        public TextView mTxtId;

        //이름
        public TextView mTxtName;

        //연인 유무
        public ImageView mImgHoney, mIProcess;

        //생일
        public TextView mTxtBirthday;

        //진행상황
        public TextView mTxtPresent;

        public LinearLayout mlList;

    }

    public FriendListViewAdapter55(Context context, ArrayList<FriendListViewItem> arrays){

        this.mContext = context;
        this.inflater = LayoutInflater.from(context);
        this.FriendArrayList = arrays;

        mDBHelper = new DBHelper(context, DBConstants.DATABASE_NAME);
    }


    @Override
    public int getCount() {
        return FriendArrayList.size();
    }

    @Override
    public FriendListViewItem getItem(int position) {
        return FriendArrayList.get(position);
    }


    private Comparator<FriendListViewItem> myComparator = new Comparator<FriendListViewItem>() {
        private final Collator collator = Collator.getInstance();

        @Override
        public int compare(FriendListViewItem object1, FriendListViewItem object2) {
            return collator.compare(object1.getIsFast(), object2.getIsFast());
        }
    };


    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void setSelectedIndex(int index) {
        mSelectedPosition = index;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if(v == null){
            viewHolder = new ListViewHolder();
            v = inflater.inflate(R.layout.listview_item_friend, null);

//            viewHolder.mTxtId = (TextView) v.findViewById(R.id.item_txt_id);
            viewHolder.mlList = (LinearLayout) v.findViewById(R.id.item_listview);
            viewHolder.mTxtName = (TextView) v.findViewById(R.id.item_txt_name);
            viewHolder.mImgHoney = (ImageView) v.findViewById(R.id.item_img_honey);
            viewHolder.mTxtBirthday = (TextView)v.findViewById(R.id.item_txt_birthday);
            viewHolder.mTxtPresent = (TextView)v.findViewById(R.id.item_txt_present);
            viewHolder.mIProcess = (ImageView) v.findViewById(R.id.item_img_process);

            v.setTag(viewHolder);

        }else {
            viewHolder = (ListViewHolder)v.getTag();
        }
/*
        if (position % 2 == 0){
            viewHolder.mlList.setBackgroundColor(Color.parseColor("#f6ddd9"));


        }
*/
        if(mSelectedPosition == position)
        {
//            viewHolder.mTxtId.setTextColor(Color.parseColor("#ff0000"));
            viewHolder.mTxtName.setTextColor(Color.parseColor("#000000"));
            viewHolder.mTxtBirthday.setTextColor(Color.parseColor("#000000"));
            viewHolder.mTxtPresent.setTextColor(Color.parseColor("#000000"));
        }
        else
        {
  //          viewHolder.mTxtId.setTextColor(Color.parseColor("#000000"));
            viewHolder.mTxtName.setTextColor(Color.parseColor("#000000"));
            viewHolder.mTxtBirthday.setTextColor(Color.parseColor("#b2936f"));
            viewHolder.mTxtPresent.setTextColor(Color.parseColor("#ef776c"));
        }

        /*
        viewHolder.mTxtId.setTag(position);
        viewHolder.mTxtId.setText(getItem(position).getId());
        */

        viewHolder.mTxtName.setTag(position);
        viewHolder.mTxtName.setText(getItem(position).getName());

        viewHolder.mTxtBirthday.setTag(position);
        viewHolder.mTxtBirthday.setText(getItem(position).getBirthday());

        viewHolder.mTxtPresent.setTag(position);

        if (FriendArrayList.get(position).getIsFinish().equals("F")&& FriendArrayList.get(position).getIsFinish_2().equals("F")){
            viewHolder.mTxtPresent.setText(getItem(position).getWill_give_gift());
        }else if (FriendArrayList.get(position).getIsFinish().equals("T")&& FriendArrayList.get(position).getIsFinish_2().equals("F")){
            viewHolder.mTxtPresent.setText(getItem(position).getWill_give_gift_2());
        }

        if (FriendArrayList.get(position).getWill_give_gift() == null || FriendArrayList.get(position).getWill_give_gift().equals("") == true){
            viewHolder.mTxtPresent.setText("계획수립");
        }




        if(FriendArrayList.get(position).getIsHoney().equals("T") && FriendArrayList.get(position).getIsFast().equals("F")) {
            viewHolder.mImgHoney.setImageResource(R.drawable.if_star);
        }else if (FriendArrayList.get(position).getIsHoney().equals("F") && FriendArrayList.get(position).getIsFast().equals("T"))
            viewHolder.mImgHoney.setImageResource(R.drawable.if_thunder);
/* 리스트 색
        if (position % 2 == 0){
            viewHolder.mlList.setBackgroundColor(Color.parseColor("#f6ddd9"));
        }
*/
//
        date1 = FriendArrayList.get(position).getBirthday();
        date2 = FriendArrayList.get(position).getBirthday_2();
        compare1 = today.compareTo(date1);
        compare2 = today.compareTo(date2);

        if (FriendArrayList.get(position).getIsFinish().equals("T")&& FriendArrayList.get(position).getIsFinish_2().equals("F")){
            viewHolder.mIProcess.setImageResource(R.drawable.go);

        }else if (FriendArrayList.get(position).getIsFinish().equals("F") && FriendArrayList.get(position).getIsFinish_2().equals("F") && compare1<0){
            viewHolder.mIProcess.setImageResource(R.drawable.go);

        }else if (FriendArrayList.get(position).getIsFinish().equals("F") && compare1>=0){
            viewHolder.mIProcess.setImageResource(R.drawable.delay);
        }else if (FriendArrayList.get(position).getIsFinish().equals("F") && FriendArrayList.get(position).getIsFinish_2().equals("F") && compare2>=0){
            viewHolder.mIProcess.setImageResource(R.drawable.delay);
        }else if (FriendArrayList.get(position).getIsFinish().equals("T") && FriendArrayList.get(position).getIsFinish_2().equals("T")){
            viewHolder.mIProcess.setImageResource(R.drawable.finish);
            viewHolder.mTxtPresent.setText("완료");

        }

        //else if (FriendArrayList.get(position).getIsFinish().equals("T") && today.compareTo(date2)>0){
        //viewHolder.mIProcess.setImageResource(R.drawable.delay);

        return v;
    }

    /*
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        int nPos = (int) buttonView.getTag();

        AlarmInfoListViewItem getItem = AlarmInfoArrayList.get(nPos);

        //어댑터와 연결된 토글 상태도 변경해줘야 한다.
        AlarmInfoArrayList.get(nPos).setAlarm(isChecked);

        String curTitle, curHour, curMinute;

        curTitle = getItem.getTitle();
        curHour = getItem.getHour();
        curMinute = getItem.getMinute();

        List<AlarmInfo> AlarmInfoList = mDBHelper.getAlarmInfoList();

        for(int i=0; i<AlarmInfoList.size(); i++) {

            AlarmInfo item = AlarmInfoList.get(i);

            if(item.getTitle().equals(curTitle) &&
                    item.getHour().equals(curHour) &&
                    item.getMinute().equals(curMinute))
            {
                String bAlarm = "";
                if(isChecked == true)
                    bAlarm = "T";
                else
                    bAlarm = "F";

                mDBHelper.deleteAlarmInfo(item.getTitle(), item.getHour(), item.getMinute());

                if(mDBHelper.insertAlarmInfo(item.getTitle(), item.getContents(), item.getHour(), item.getMinute(), item.getAlarmId(), bAlarm))
                {
                    if(isChecked == false)
                    {
                        int AlarmId = Integer.parseInt(item.getAlarmId());
                        AlarmUtil.unregisterAlarm(mContext, AlarmId);
                    }
                    Toast.makeText(mContext, "알람 설정 변경", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    */
}
