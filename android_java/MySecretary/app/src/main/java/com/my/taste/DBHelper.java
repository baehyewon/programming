package com.my.taste;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

//sqlLite DB
public class DBHelper extends SQLiteOpenHelper {
    private static final String TAG = "DBHelper";
    static boolean mPrint_Log = false;

    public DBHelper(Context context, String name) {
        super(context, name, null, DBConstants.DATABASE_VERSION);
    }
    //////////////////////////////////////////////////////////////////////////////////////////생성
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "DB onCreate!\n");

        db.execSQL("CREATE TABLE " + DBConstants.TasteTable.TblNAMEE + " ( "
                + DBConstants.TasteTable.Column.ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DBConstants.TasteTable.Column.NAME + " text, "
                + DBConstants.TasteTable.Column.PHONE + " text,"
                + DBConstants.TasteTable.Column.IS_HONEY + " text,"
                + DBConstants.TasteTable.Column.BIRTHDAY + " text, "
                + DBConstants.TasteTable.Column.ALARM_DATE + " text,"
                + DBConstants.TasteTable.Column.ALARM_HOUR + " text,"
                + DBConstants.TasteTable.Column.ALARM_MINUTE + " text,"
                + DBConstants.TasteTable.Column.ALARM_ID + " text,"
                + DBConstants.TasteTable.Column.STYLE + " text,"
                + DBConstants.TasteTable.Column.LIKE + " text,"
                + DBConstants.TasteTable.Column.WILL_GIVE_GIFT + " text,"
                + DBConstants.TasteTable.Column.WILL_GIVE_GIFT_2 + " text,"
                + DBConstants.TasteTable.Column.ALARM_MESSAGE + " text,"
                + DBConstants.TasteTable.Column.PHONE_2 + " text,"
                + DBConstants.TasteTable.Column.BIRTHDAY_2 + " text, "
                + DBConstants.TasteTable.Column.ALARM_DATE_2 + " text,"
                + DBConstants.TasteTable.Column.ALARM_HOUR_2 + " text,"
                + DBConstants.TasteTable.Column.ALARM_MINUTE_2 + " text,"
                + DBConstants.TasteTable.Column.ALARM_ID_2 + " text,"
                + DBConstants.TasteTable.Column.STYLE_2 + " text,"
                + DBConstants.TasteTable.Column.LIKE_2 + " text,"
                + DBConstants.TasteTable.Column.IS_FAST + " text,"
                + DBConstants.TasteTable.Column.IS_FINISH + " text,"
                + DBConstants.TasteTable.Column.IS_FINISH_2 + " text,"
                + DBConstants.TasteTable.Column.NOTICE + " text,"
                + DBConstants.TasteTable.Column.ALARM_MESSAGE_2 + " text) "

        );
  }

    //////////////////////////////////////////////////////////////////////////////////////////갱신
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBConstants.TasteTable.TblNAMEE);

        onCreate(db);
    }

    //////////////////////////////////////////////////////////////////////////////////////////DB삽입
    public int insertDB(
            String name,
            String phone,
            String is_honey,
            String birthday,
            String alarm_date,
            String alarm_hour,
            String alarm_minute,
            String alarm_id,
            String style,
            String like,
            String will_give_gift,
            String will_give_gift_2,
            String alarm_msg,
            String phone_2,
            String birthday_2,
            String alarm_date_2,
            String alarm_hour_2,
            String alarm_minute_2,
            String alarm_id_2,
            String style_2,
            String like_2,
            String is_fast,
            String is_finish,
            String is_finish_2,
            String notice,
            String alarm_msg_2
    )
    {
        long row_id = -1;

        SQLiteDatabase database = getWritableDatabase();

        String columns[] = { DBConstants.TasteTable.Column.ID,
                DBConstants.TasteTable.Column.NAME,
                DBConstants.TasteTable.Column.PHONE,
                DBConstants.TasteTable.Column.IS_HONEY,
                DBConstants.TasteTable.Column.BIRTHDAY,
                DBConstants.TasteTable.Column.ALARM_DATE,
                DBConstants.TasteTable.Column.ALARM_HOUR,
                DBConstants.TasteTable.Column.ALARM_MINUTE,
                DBConstants.TasteTable.Column.ALARM_ID,
                DBConstants.TasteTable.Column.STYLE,
                DBConstants.TasteTable.Column.LIKE,
                DBConstants.TasteTable.Column.WILL_GIVE_GIFT,
                DBConstants.TasteTable.Column.WILL_GIVE_GIFT_2,
                DBConstants.TasteTable.Column.ALARM_MESSAGE,
                DBConstants.TasteTable.Column.PHONE,
                DBConstants.TasteTable.Column.BIRTHDAY,
                DBConstants.TasteTable.Column.ALARM_DATE,
                DBConstants.TasteTable.Column.ALARM_HOUR,
                DBConstants.TasteTable.Column.ALARM_MINUTE,
                DBConstants.TasteTable.Column.ALARM_ID,
                DBConstants.TasteTable.Column.STYLE,
                DBConstants.TasteTable.Column.LIKE,
                DBConstants.TasteTable.Column.IS_FAST,
                DBConstants.TasteTable.Column.IS_FINISH,
                DBConstants.TasteTable.Column.IS_FINISH_2,
                DBConstants.TasteTable.Column.NOTICE,
                DBConstants.TasteTable.Column.ALARM_MESSAGE_2,
        };

        String order_by = DBConstants.TasteTable.Column.BIRTHDAY;

        Cursor cursor = null;

        cursor = database.query(DBConstants.TasteTable.TblNAMEE, columns,
                null, null, null, null, order_by, null);

        cursor.moveToFirst();

        String table = DBConstants.TasteTable.TblNAMEE;

        for(int i = 0 ; i < cursor.getCount() ; i++){

            int IdColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.ID);
            int NamdColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.NAME);

            String whereClause = DBConstants.TasteTable.Column.ID + " = ? ";
            String[] whereArgs = new String[] { cursor.getString(IdColumn) };

            //Name이 일치할 경우 DB추가 실패 처리
            if(name.equals(cursor.getString(NamdColumn)))
            {
                return 100;
            }

            cursor.moveToNext();
        }

        ContentValues values = new ContentValues();
        values.put(DBConstants.TasteTable.Column.NAME, name);
        values.put(DBConstants.TasteTable.Column.PHONE, phone);
        values.put(DBConstants.TasteTable.Column.IS_HONEY, is_honey);
        values.put(DBConstants.TasteTable.Column.BIRTHDAY, birthday);
        values.put(DBConstants.TasteTable.Column.ALARM_DATE, alarm_date);
        values.put(DBConstants.TasteTable.Column.ALARM_HOUR, alarm_hour);
        values.put(DBConstants.TasteTable.Column.ALARM_MINUTE, alarm_minute);
        values.put(DBConstants.TasteTable.Column.ALARM_ID, alarm_id);
        values.put(DBConstants.TasteTable.Column.STYLE, style);
        values.put(DBConstants.TasteTable.Column.LIKE, like);
        values.put(DBConstants.TasteTable.Column.WILL_GIVE_GIFT, will_give_gift);
        values.put(DBConstants.TasteTable.Column.WILL_GIVE_GIFT_2, will_give_gift_2);
        values.put(DBConstants.TasteTable.Column.ALARM_MESSAGE, alarm_msg);
        values.put(DBConstants.TasteTable.Column.PHONE_2, phone_2);
        values.put(DBConstants.TasteTable.Column.BIRTHDAY_2, birthday_2);
        values.put(DBConstants.TasteTable.Column.ALARM_DATE_2, alarm_date_2);
        values.put(DBConstants.TasteTable.Column.ALARM_HOUR_2, alarm_hour_2);
        values.put(DBConstants.TasteTable.Column.ALARM_MINUTE_2, alarm_minute_2);
        values.put(DBConstants.TasteTable.Column.ALARM_ID_2, alarm_id_2);
        values.put(DBConstants.TasteTable.Column.STYLE_2, style_2);
        values.put(DBConstants.TasteTable.Column.LIKE_2, like_2);
        values.put(DBConstants.TasteTable.Column.IS_FAST, is_fast);
        values.put(DBConstants.TasteTable.Column.IS_FINISH, is_finish);
        values.put(DBConstants.TasteTable.Column.IS_FINISH_2, is_finish_2);
        values.put(DBConstants.TasteTable.Column.NOTICE, notice);
        values.put(DBConstants.TasteTable.Column.ALARM_MESSAGE_2, alarm_msg_2);
        row_id = database.insert(DBConstants.TasteTable.TblNAMEE, null,
                values);

        cursor.close();
        database.close();

        if (row_id == -1)
            return 0;

        return 1;
    }

    //DB 전체 삭제
    public void deleteDB() {

        SQLiteDatabase database = getWritableDatabase();

        database.delete(DBConstants.TasteTable.TblNAMEE, null, null);

        database.close();
    }

    //name 기준으로 컬럼 삭제
    public boolean deleteDB(String name/*, String phone*/) {

        SQLiteDatabase database = getWritableDatabase();

        String table = DBConstants.TasteTable.TblNAMEE;

        /*
        String whereClause = DBConstants.TasteTable.Column.NAME + " = ? " + "AND " + DBConstants.TasteTable.Column.PHONE + " = ? ";
        String[] whereArgs = new String[] { name, phone};
        */
        String whereClause = DBConstants.TasteTable.Column.NAME + " = ? ";
        String[] whereArgs = new String[] { name };

        if (database.delete(table, whereClause, whereArgs) == 1) {
            database.close();
            return true;
        } else {
            database.close();
            return false;
        }
    }

    public List<FriendInfo> getFriendList() {

        String columns[] = { DBConstants.TasteTable.Column.ID,
                DBConstants.TasteTable.Column.NAME,
                DBConstants.TasteTable.Column.PHONE,
                DBConstants.TasteTable.Column.IS_HONEY,
                DBConstants.TasteTable.Column.BIRTHDAY,
                DBConstants.TasteTable.Column.ALARM_DATE,
                DBConstants.TasteTable.Column.ALARM_HOUR,
                DBConstants.TasteTable.Column.ALARM_MINUTE,
                DBConstants.TasteTable.Column.ALARM_ID,
                DBConstants.TasteTable.Column.STYLE,
                DBConstants.TasteTable.Column.LIKE,
                DBConstants.TasteTable.Column.WILL_GIVE_GIFT,
                DBConstants.TasteTable.Column.WILL_GIVE_GIFT_2,
                DBConstants.TasteTable.Column.ALARM_MESSAGE,
                DBConstants.TasteTable.Column.PHONE_2,
                DBConstants.TasteTable.Column.BIRTHDAY_2,
                DBConstants.TasteTable.Column.ALARM_DATE_2,
                DBConstants.TasteTable.Column.ALARM_HOUR_2,
                DBConstants.TasteTable.Column.ALARM_MINUTE_2,
                DBConstants.TasteTable.Column.ALARM_ID_2,
                DBConstants.TasteTable.Column.STYLE_2,
                DBConstants.TasteTable.Column.LIKE_2,
                DBConstants.TasteTable.Column.IS_FAST,
                DBConstants.TasteTable.Column.IS_FINISH,
                DBConstants.TasteTable.Column.IS_FINISH_2,
                DBConstants.TasteTable.Column.NOTICE,
                DBConstants.TasteTable.Column.ALARM_MESSAGE_2
        };

        String order_by = DBConstants.TasteTable.Column.BIRTHDAY;

        Cursor cursor = null;

        SQLiteDatabase database = getWritableDatabase();

        List<FriendInfo> TasteList = new ArrayList<FriendInfo>();

        try {
            cursor = database.query(DBConstants.TasteTable.TblNAMEE, columns,
                    "", new String[] {}, null, null, order_by, null);

            int IdColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.ID);
            int NameColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.NAME);
            int PhoneColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.PHONE);
            int IsHoneyColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.IS_HONEY);
            int BirthdayColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.BIRTHDAY);
            int AlarmDateColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.ALARM_DATE);
            int AlarmHourColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.ALARM_HOUR);
            int AlarmMinuteColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.ALARM_MINUTE);
            int AlarmIdColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.ALARM_ID);

            int StyleColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.STYLE);
            int LikeColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.LIKE);
            int WillGiveGiftColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.WILL_GIVE_GIFT);
            int WillGiveGift_2Column = cursor.getColumnIndex(DBConstants.TasteTable.Column.WILL_GIVE_GIFT_2);

            int Phone_2Column = cursor.getColumnIndex(DBConstants.TasteTable.Column.PHONE_2);
            int Birthday_2Column = cursor.getColumnIndex(DBConstants.TasteTable.Column.BIRTHDAY_2);
            int AlarmDate_2Column = cursor.getColumnIndex(DBConstants.TasteTable.Column.ALARM_DATE_2);
            int AlarmHour_2Column = cursor.getColumnIndex(DBConstants.TasteTable.Column.ALARM_HOUR_2);
            int AlarmMinute_2Column = cursor.getColumnIndex(DBConstants.TasteTable.Column.ALARM_MINUTE_2);
            int AlarmId_2Column = cursor.getColumnIndex(DBConstants.TasteTable.Column.ALARM_ID_2);

            int Style_2Column = cursor.getColumnIndex(DBConstants.TasteTable.Column.STYLE_2);
            int Like_2Column = cursor.getColumnIndex(DBConstants.TasteTable.Column.LIKE_2);

            int IsFastColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.IS_FAST);
            int IsFinishColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.IS_FINISH);
            int IsFinish_2Column = cursor.getColumnIndex(DBConstants.TasteTable.Column.IS_FINISH_2);

            int AlarmMsgColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.ALARM_MESSAGE);
            int AlarmMsg_2Column = cursor.getColumnIndex(DBConstants.TasteTable.Column.ALARM_MESSAGE_2);
            int NoticeColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.NOTICE);

            while (cursor.moveToNext()) {
                FriendInfo item = new FriendInfo();

                item.setId(cursor.getString(IdColumn));
                item.setName(cursor.getString(NameColumn));
                item.setPhone(cursor.getString(PhoneColumn));
                item.setIsHoney(cursor.getString(IsHoneyColumn));

                item.setBirthday(cursor.getString(BirthdayColumn));
                item.setAlarmDate(cursor.getString(AlarmDateColumn));
                item.setAlarmHour(cursor.getString(AlarmHourColumn));
                item.setAlarmMinute(cursor.getString(AlarmMinuteColumn));
                item.setAlarmId(cursor.getString(AlarmIdColumn));

                item.setStyle(cursor.getString(StyleColumn));
                item.setLike(cursor.getString(LikeColumn));
                item.setWillGiveGift(cursor.getString(WillGiveGiftColumn));
                item.setWillGiveGift_2(cursor.getString(WillGiveGift_2Column));
                item.setAlarmMsg(cursor.getString(AlarmMsgColumn));

                item.setPhone_2(cursor.getString(Phone_2Column));
                item.setBirthday_2(cursor.getString(Birthday_2Column));
                item.setAlarmDate_2(cursor.getString(AlarmDate_2Column));
                item.setAlarmHour_2(cursor.getString(AlarmHour_2Column));
                item.setAlarmMinute_2(cursor.getString(AlarmMinute_2Column));
                item.setAlarmId_2(cursor.getString(AlarmId_2Column));

                item.setStyle_2(cursor.getString(Style_2Column));
                item.setLike_2(cursor.getString(Like_2Column));

                item.setIsFast(cursor.getString(IsFastColumn));
                item.setIsFinish(cursor.getString(IsFinishColumn));
                item.setIsFinish_2(cursor.getString(IsFinish_2Column));

                item.setNotice(cursor.getString(NoticeColumn));
                item.setAlarmMsg_2(cursor.getString(AlarmMsg_2Column));

                TasteList.add(item);
            }

        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (database != null) {
                database.close();
            }
        }

        return TasteList;
    }

    public int getLastAlarmId() {

        int AlarmId = 0;

        String columns[] = { DBConstants.TasteTable.Column.ID,
                DBConstants.TasteTable.Column.NAME,
                DBConstants.TasteTable.Column.PHONE,
                DBConstants.TasteTable.Column.IS_HONEY,
                DBConstants.TasteTable.Column.BIRTHDAY,
                DBConstants.TasteTable.Column.ALARM_DATE,
                DBConstants.TasteTable.Column.ALARM_HOUR,
                DBConstants.TasteTable.Column.ALARM_MINUTE,
                DBConstants.TasteTable.Column.ALARM_ID,
                DBConstants.TasteTable.Column.STYLE,
                DBConstants.TasteTable.Column.LIKE,
                DBConstants.TasteTable.Column.WILL_GIVE_GIFT,
                DBConstants.TasteTable.Column.WILL_GIVE_GIFT_2,
                DBConstants.TasteTable.Column.ALARM_MESSAGE,
                DBConstants.TasteTable.Column.PHONE_2,
                DBConstants.TasteTable.Column.BIRTHDAY_2,
                DBConstants.TasteTable.Column.ALARM_DATE_2,
                DBConstants.TasteTable.Column.ALARM_HOUR_2,
                DBConstants.TasteTable.Column.ALARM_MINUTE_2,
                DBConstants.TasteTable.Column.ALARM_ID_2,
                DBConstants.TasteTable.Column.STYLE_2,
                DBConstants.TasteTable.Column.LIKE_2,
                DBConstants.TasteTable.Column.IS_FAST,
                DBConstants.TasteTable.Column.IS_FINISH,
                DBConstants.TasteTable.Column.IS_FINISH_2,
                DBConstants.TasteTable.Column.NOTICE,
                DBConstants.TasteTable.Column.ALARM_MESSAGE_2
        };

        String order_by = DBConstants.TasteTable.Column.BIRTHDAY;

        Cursor cursor = null;

        SQLiteDatabase database = getWritableDatabase();

        try {
            cursor = database.query(DBConstants.TasteTable.TblNAMEE, columns,
                    "", new String[] {}, null, null, order_by, null);

            int alarmIdColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.ALARM_ID);

            while (cursor.moveToNext()) {

                AlarmId = Integer.parseInt(cursor.getString(alarmIdColumn));
            }

        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (database != null) {
                database.close();
            }
        }

        return AlarmId;
    }

    public int getLastAlarmId_2() {

        int AlarmId_2 = 0;

        String columns[] = { DBConstants.TasteTable.Column.ID,
                DBConstants.TasteTable.Column.NAME,
                DBConstants.TasteTable.Column.PHONE,
                DBConstants.TasteTable.Column.IS_HONEY,
                DBConstants.TasteTable.Column.BIRTHDAY,
                DBConstants.TasteTable.Column.ALARM_DATE,
                DBConstants.TasteTable.Column.ALARM_HOUR,
                DBConstants.TasteTable.Column.ALARM_MINUTE,
                DBConstants.TasteTable.Column.ALARM_ID,
                DBConstants.TasteTable.Column.STYLE,
                DBConstants.TasteTable.Column.LIKE,
                DBConstants.TasteTable.Column.WILL_GIVE_GIFT,
                DBConstants.TasteTable.Column.WILL_GIVE_GIFT_2,
                DBConstants.TasteTable.Column.ALARM_MESSAGE,
                DBConstants.TasteTable.Column.PHONE_2,
                DBConstants.TasteTable.Column.BIRTHDAY_2,
                DBConstants.TasteTable.Column.ALARM_DATE_2,
                DBConstants.TasteTable.Column.ALARM_HOUR_2,
                DBConstants.TasteTable.Column.ALARM_MINUTE_2,
                DBConstants.TasteTable.Column.ALARM_ID_2,
                DBConstants.TasteTable.Column.STYLE_2,
                DBConstants.TasteTable.Column.LIKE_2,
                DBConstants.TasteTable.Column.IS_FAST,
                DBConstants.TasteTable.Column.IS_FINISH,
                DBConstants.TasteTable.Column.IS_FINISH_2,
                DBConstants.TasteTable.Column.NOTICE,
                DBConstants.TasteTable.Column.ALARM_MESSAGE_2
        };

        String order_by = DBConstants.TasteTable.Column.BIRTHDAY;

        Cursor cursor = null;

        SQLiteDatabase database = getWritableDatabase();

        try {
            cursor = database.query(DBConstants.TasteTable.TblNAMEE, columns,
                    "", new String[] {}, null, null, order_by, null);

            int alarmIdColumn = cursor.getColumnIndex(DBConstants.TasteTable.Column.ALARM_ID_2);

            while (cursor.moveToNext()) {

                AlarmId_2 = Integer.parseInt(cursor.getString(alarmIdColumn));
            }

        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (database != null) {
                database.close();
            }
        }

        return AlarmId_2;
    }
}