package com.my.taste;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;


import com.my.taste.dial.AlarmActivity_2;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class AlarmUtil_2 {

    public static void setAlarm_2(Context context, int AlarmId_2, String Name_2, String Phone_2, String Birthday_2,String Message_2, int year_2, int month_2, int day_2, int hour_2, int minute_2, String Will_given_gift)
    {
        // AlarmManager 호출
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance( );  // 현재 날짜/시간 등의 각종 정보 얻기

        /*
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        */

        calendar.set(Calendar.YEAR, year_2);
        calendar.set(Calendar.MONTH, month_2);
        calendar.set(Calendar.DAY_OF_MONTH, day_2);

        calendar.set(Calendar.HOUR, hour_2);
        calendar.set(Calendar.MINUTE, minute_2);
        calendar.set(Calendar.SECOND, 00);

        /*
        if(hour < 12)
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
            */

        GregorianCalendar gregorianCalendar_2 = new GregorianCalendar(TimeZone.getTimeZone("GMT+09:00"));

        gregorianCalendar_2.set(year_2, month_2, day_2, hour_2, minute_2, 00);

        Intent intent = new Intent(context, AlarmActivity_2.class);

        intent.setAction("Alarm");
        intent.addCategory("setAlarm");

        intent.putExtra("alarmId", AlarmId_2);
        intent.putExtra("name", Name_2);
        intent.putExtra("phone", Phone_2);
        intent.putExtra("birthday", Birthday_2);
        intent.putExtra("message", Message_2);
        intent.putExtra("will_given_gift", Will_given_gift);

///
        PendingIntent pi_2 = PendingIntent.getActivity(context, AlarmId_2, intent, PendingIntent.FLAG_UPDATE_CURRENT );
        manager.setRepeating(AlarmManager.RTC_WAKEUP, gregorianCalendar_2.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pi_2);
    }



    public static void unregisterAlarm(Context context, int AlarmID_2)
    {
        Intent intent = new Intent(context, AlarmActivity_2.class);
        intent.setAction("Alarm");
        intent.addCategory("setAlarm");

        PendingIntent pi = PendingIntent.getActivity(context, AlarmID_2, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        pi.cancel();
        alarmManager.cancel(pi);
    }
/*
    public static void unregisterSms(Context context, int AlarmID_2)
    {
        Intent intent = new Intent(context, SmsActivity_2.class);
        intent.setAction("Sms");
        intent.addCategory("setSms");

        PendingIntent pi = PendingIntent.getActivity(context, AlarmID_2, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        pi.cancel();
        alarmManager.cancel(pi);
    }*/

}
