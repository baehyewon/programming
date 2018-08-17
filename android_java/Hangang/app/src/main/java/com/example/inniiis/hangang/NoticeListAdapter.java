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

public class NoticeListAdapter extends BaseAdapter {

    private ArrayList<Notice> noticeList = new ArrayList<>();

    @Override
    public int getCount() {
        return noticeList.size();
    }

    @Override
    public Notice getItem(int position) {
        return noticeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();

        Notice myNotice = getItem(position);

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.itemstyle, parent, false);
        }
        //View v = View.inflate(context, R.layout.itemstyle, null);
        TextView tv_title = (TextView) convertView.findViewById(R.id.tv_title);
        TextView tv_writer =  (TextView) convertView.findViewById(R.id.tv_writer);
        TextView tv_date =  (TextView) convertView.findViewById(R.id.tv_date);



        tv_title.setText(myNotice.getTitle());
        tv_writer.setText(myNotice.getWriter());
        tv_date.setText(myNotice.getDate());

        return convertView;
    }

    public void addItem(String title, String writer, String date) {
        Notice mnotice = new Notice();

        mnotice.setTitle(title);
        mnotice.setWriter(writer);
        mnotice.setDate(date);

        noticeList.add(mnotice);
    }
}