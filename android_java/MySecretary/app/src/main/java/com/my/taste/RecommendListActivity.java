package com.my.taste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class RecommendListActivity extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    private CheckBox chk1, chk2, chk3, chk4, chk5, chk6, chk7, chk8, chk9, chk10, chk11;

    private Button btnResult;

    private boolean bChecked[] = new boolean[11];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_list);

        chk1 = findViewById(R.id.afl_chk1);
        chk1.setOnCheckedChangeListener(this);

        chk2 = findViewById(R.id.afl_chk2);
        chk2.setOnCheckedChangeListener(this);

        chk3 = findViewById(R.id.afl_chk3);
        chk3.setOnCheckedChangeListener(this);

        chk4 = findViewById(R.id.afl_chk4);
        chk4.setOnCheckedChangeListener(this);

        chk5 = findViewById(R.id.afl_chk5);
        chk5.setOnCheckedChangeListener(this);

        chk6 = findViewById(R.id.afl_chk6);
        chk6.setOnCheckedChangeListener(this);

        chk7 = findViewById(R.id.afl_chk7);
        chk7.setOnCheckedChangeListener(this);

        chk8 = findViewById(R.id.afl_chk8);
        chk8.setOnCheckedChangeListener(this);

        chk9 = findViewById(R.id.afl_chk9);
        chk9.setOnCheckedChangeListener(this);

        chk10 = findViewById(R.id.afl_chk10);
        chk10.setOnCheckedChangeListener(this);

        chk11 = findViewById(R.id.afl_chk11);
        chk11.setOnCheckedChangeListener(this);

        btnResult = findViewById(R.id.afl_btn_result);
        btnResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent intent = null;

        switch (view.getId())
        {
            case R.id.afl_btn_result:

                intent = new Intent();
                intent.putExtra("checkResult", bChecked);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        switch (compoundButton.getId())
        {
            case R.id.afl_chk1:
                bChecked[0] = compoundButton.isChecked();
                break;

            case R.id.afl_chk2:
                bChecked[1] = compoundButton.isChecked();
                break;

            case R.id.afl_chk3:
                bChecked[2] = compoundButton.isChecked();
                break;

            case R.id.afl_chk4:
                bChecked[3] = compoundButton.isChecked();
                break;

            case R.id.afl_chk5:
                bChecked[4] = compoundButton.isChecked();
                break;

            case R.id.afl_chk6:
                bChecked[5] = compoundButton.isChecked();
                break;

            case R.id.afl_chk7:
                bChecked[6] = compoundButton.isChecked();
                break;

            case R.id.afl_chk8:
                bChecked[7] = compoundButton.isChecked();
                break;

            case R.id.afl_chk9:
                bChecked[8] = compoundButton.isChecked();
                break;

            case R.id.afl_chk10:
                bChecked[9] = compoundButton.isChecked();
                break;

            case R.id.afl_chk11:
                bChecked[10] = compoundButton.isChecked();
                break;
        }
    }
}
