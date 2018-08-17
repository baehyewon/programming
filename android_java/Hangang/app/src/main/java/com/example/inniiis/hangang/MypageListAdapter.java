package com.example.inniiis.hangang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by inniiis on 2017-06-07.
 */

public class MypageListAdapter extends BaseAdapter {

    private ArrayList<Mypage> mypageList = new ArrayList<>();

    @Override
    public int getCount() {
        return mypageList.size();
    }

    @Override
    public Mypage getItem(int position) {
        return mypageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();

        Mypage myMypage = getItem(position);

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.itemstyle2, parent, false);
        }
        //View v = View.inflate(context, R.layout.itemstyle, null);
        TextView tv_river = (TextView) convertView.findViewById(R.id.tv_river);
        TextView tv_facility =  (TextView) convertView.findViewById(R.id.tv_facility);
        TextView tv_date =  (TextView) convertView.findViewById(R.id.tv_date);
        TextView tv_adult =  (TextView) convertView.findViewById(R.id.tv_adult);
        TextView tv_baby =  (TextView) convertView.findViewById(R.id.tv_baby);

        tv_river.setText(myMypage.getRiver());
        tv_facility.setText(myMypage.getFacility());
        tv_date.setText(myMypage.getDate());
        tv_adult.setText(myMypage.getAdult());
        tv_baby.setText(myMypage.getBaby());

        return convertView;
    }

    public void addItem(String river, String facility, String date, String adult, String baby) {
        Mypage mmypage = new Mypage();

        mmypage.setRiver(river);
        mmypage.setFacility(facility);
        mmypage.setDate(date);
        mmypage.setAdult(adult);
        mmypage.setBaby(baby);

        mypageList.add(mmypage);
    }

}