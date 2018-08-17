package com.example.inniiis.hangang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.NumberPicker;
import android.widget.Toast;

/**
 * Created by inniiis on 2017-06-08.
 */

public class PopupActivity extends AppCompatActivity {
    NumberPicker adult;
    NumberPicker student;
    NumberPicker baby;
    int numadult;
    int numbaby;
    int check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_popup);

        adult = (NumberPicker) findViewById(R.id.adult);
        adult.setMinValue(0);
        adult.setMaxValue(10);
        adult.setWrapSelectorWheel(false);
        adult.setOnScrollListener(onScrollListener);

        baby = (NumberPicker) findViewById(R.id.baby);
        baby.setMinValue(0);
        baby.setMaxValue(10);
        baby.setWrapSelectorWheel(false);
        baby.setOnScrollListener(onScrollListener);
    }

    NumberPicker.OnScrollListener onScrollListener = new NumberPicker.OnScrollListener() {
        @Override
        public void onScrollStateChange(NumberPicker view, int scrollState) {
            NumberPicker picker = view;

            if (scrollState == SCROLL_STATE_IDLE) {
                if(view.getId() == R.id.adult)
                    numadult = picker.getValue();
                if(view.getId() == R.id.baby)
                    numbaby = picker.getValue();

                Toast toast = Toast.makeText(PopupActivity.this,"대인 : "+ numadult + " 명, 소인 : "+ numbaby+" 명",Toast.LENGTH_SHORT);
                toast.show();
            }

        }
    };

    //확인 버튼 클릭
    public void mOnok(View v) {
        check = 0;
        Toast toast = Toast.makeText(PopupActivity.this,"대인 : "+ numadult + " 명, 소인 : "+ numbaby+" 명",Toast.LENGTH_SHORT);
        toast.show();
        //데이터 전달하기
        Intent intent = new Intent();
        intent.putExtra("adult", numadult);
        intent.putExtra("baby", numbaby);
        intent.putExtra("check", check);
        setResult(RESULT_OK, intent);
        finish();
    }

    //취소 버튼 클릭
    public void mOnclose(View v) {
        //액티비티(팝업) 닫기
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
}
