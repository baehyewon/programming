package com.my.taste;

import android.provider.BaseColumns;

//DB 테이블 구성
public class DBConstants implements BaseColumns {

    public static final class TasteTable implements BaseColumns {
        public static final class Column {

            // Column ID
            public static final String ID = "id";
            //이름
            public static final String NAME = "name";
            //전화번호
            public static final String PHONE = "phone";

            //전화번호
            public static final String PHONE_2 = "phone_2";

            //연인 유무
            public static final String IS_HONEY = "is_honey";

            //생일
            public static final String BIRTHDAY = "birthday";

            //알람 날짜
            public static final String ALARM_DATE = "alarm_date";

            //알람 설정 시간(시)
            public static final String ALARM_HOUR = "alarm_hour";

            //알람 설정 시간(분)
            public static final String ALARM_MINUTE = "alarm_minute";

            //알람 ID
            public static final String ALARM_ID = "alarm_id";

            //스타일
            public static final String STYLE = "style";

            //피드백
            public static final String LIKE = "like";

            //생일
            public static final String BIRTHDAY_2 = "birthday_2";

            //알람 날짜
            public static final String ALARM_DATE_2 = "alarm_date_2";

            //알람 설정 시간(시)
            public static final String ALARM_HOUR_2 = "alarm_hour_2";

            //알람 설정 시간(분)
            public static final String ALARM_MINUTE_2 = "alarm_minute_2";

            //알람 ID
            public static final String ALARM_ID_2 = "alarm_id_2";

            //스타일
            public static final String STYLE_2 = "style_2";

            //피드백
            public static final String LIKE_2 = "like_2";

            //진행단계
            public static final String WILL_GIVE_GIFT = "will_give_gift";

            //진행단계
            public static final String WILL_GIVE_GIFT_2 = "will_give_gift_2";

            //축하 메시지
            public static final String ALARM_MESSAGE = "alarm_msg";

            public static final String IS_FAST = "is_fast";
            public static final String IS_FINISH = "is_finish";
            public static final String IS_FINISH_2 = "is_finish_2";

            //착안사항
            public static final String NOTICE = "notice";
            //축하 메시지
            public static final String ALARM_MESSAGE_2 = "alarm_msg_2";

        }

        //Table Name
        public static final String TblNAMEE = "TasteTable";

        private TasteTable() {

        }
    }

    public static final String DATABASE_NAME = "taste.db";

    public static final int DATABASE_VERSION = 1;

    private DBConstants() {

    }
}