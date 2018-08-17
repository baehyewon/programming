package com.my.taste;

import android.os.Parcel;
import android.os.Parcelable;

public class FriendInfo implements Parcelable {

    protected FriendInfo(Parcel in) {
//        readFromParcel(in);
    }

    public static final Creator<FriendInfo> CREATOR = new Creator<FriendInfo>() {
        @Override
        public FriendInfo createFromParcel(Parcel in) {
            return new FriendInfo(in);
        }

        @Override
        public FriendInfo[] newArray(int size) {
            return new FriendInfo[size];
        }
    };

    private String id;

    private String name;

    private String phone;
    private String phone_2;

    private String is_honey;
    private String is_fast;
    private String is_finish;
    private String is_finish_2;

    private String birthday;

    private String alarm_date;

    private String alarm_hour;

    private String alarm_minute;

    private String alarm_id;

    private String style;
    private String like;
    private String will_give_gift;
    private String will_give_gift_2;

    private String birthday_2;

    private String alarm_date_2;

    private String alarm_hour_2;

    private String alarm_minute_2;

    private String alarm_id_2;

    private String style_2;
    private String like_2;

    private String alarm_msg;
    private String notice;
    private String alarm_msg_2;

    public FriendInfo() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPhone_2() {
        return phone_2;
    }

    public String getIsHoney() {
        return is_honey;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAlarmDate() {
        return alarm_date;
    }

    public String getAlarmHour() {
        return alarm_hour;
    }

    public String getAlarmMinute() {
        return alarm_minute;
    }

    public String getAlarmId() {
        return alarm_id;
    }

    public String getStyle() {
        return style;
    }
    public String getLike() {
        return like;
    }
    public String getWillGiveGift() {
        return will_give_gift;
    }
    public String getWillGiveGift_2() {
        return will_give_gift_2;
    }

    public String getBirthday_2() {
        return birthday_2;
    }

    public String getAlarmDate_2() {
        return alarm_date_2;
    }

    public String getAlarmHour_2() {
        return alarm_hour_2;
    }

    public String getAlarmMinute_2() {
        return alarm_minute_2;
    }

    public String getAlarmId_2() {
        return alarm_id_2;
    }

    public String getStyle_2() {
        return style_2;
    }
    public String getLike_2() {
        return like_2;
    }

    public String getAlarmMsg() {
        return alarm_msg;
    }

    public String getIsFast() {
        return is_fast;
    }
    public String getIsFinish() {
        return is_finish;
    }
    public String getIsFinish_2() {
        return is_finish_2;
    }

    public String getNotice() {
        return notice;
    }
    public String getAlarmMsg_2() {
        return alarm_msg_2;
    }


    /////////////////

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setPhone_2(String phone_2) {
        this.phone_2 = phone_2;
    }

    public void setIsHoney(String is_honey) {
        this.is_honey = is_honey;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setAlarmDate(String alarm_date) {
        this.alarm_date = alarm_date;
    }

    public void setAlarmHour(String alarm_hour) {
        this.alarm_hour= alarm_hour;
    }

    public void setAlarmMinute(String alarm_minute) {
        this.alarm_minute = alarm_minute;
    }

    public void setAlarmId(String alarm_id) {
        this.alarm_id = alarm_id;
    }

    public void setStyle(String style) {
        this.style = style;
    }
    public void setLike(String like) {
        this.like = like;
    }
    public void setWillGiveGift(String will_give_gift) {
        this.will_give_gift = will_give_gift;
    }

    public void setWillGiveGift_2(String will_give_gift_2) {
        this.will_give_gift_2 = will_give_gift_2;
    }

    public void setBirthday_2(String birthday_2) {
        this.birthday_2 = birthday_2;
    }

    public void setAlarmDate_2(String alarm_date_2) {
        this.alarm_date_2 = alarm_date_2;
    }

    public void setAlarmHour_2(String alarm_hour_2) {
        this.alarm_hour_2= alarm_hour_2;
    }

    public void setAlarmMinute_2(String alarm_minute_2) {
        this.alarm_minute_2 = alarm_minute_2;
    }

    public void setAlarmId_2(String alarm_id_2) {
        this.alarm_id_2 = alarm_id_2;
    }

    public void setStyle_2(String style_2) {
        this.style_2 = style_2;
    }
    public void setLike_2(String like_2) {
        this.like_2 = like_2;
    }

    public void setIsFast(String is_fast) {
        this.is_fast = is_fast;
    }
    public void setIsFinish(String is_finish) {
        this.is_finish = is_finish;
    }
    public void setIsFinish_2(String is_finish_2) {
        this.is_finish_2 = is_finish_2;
    }

    public void setAlarmMsg(String alarm_msg) {
        this.alarm_msg = alarm_msg;
    }
    public void setNotice(String notice) {
        this.notice = notice;
    }

    public void setAlarmMsg_2(String alarm_msg_2) {
        this.alarm_msg_2 = alarm_msg_2;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        /*
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(birthday);
        dest.writeString(sex);
        dest.writeString(color);
        dest.writeString(alarm);
        */
    }
}