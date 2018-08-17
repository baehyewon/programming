package com.example.inniiis.hangang;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public static String id;
    private AlertDialog dialog;
    private boolean validate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText idText = (EditText) findViewById(R.id.loginid);
        final EditText passwordText = (EditText) findViewById(R.id.loginpw);

        Button btnologin = (Button)findViewById(R.id.nologin);
        btnologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("!!!! : ", "ok");
                Intent loginIntent = new Intent(MainActivity.this, List2Activity.class);
                MainActivity.this.startActivity(loginIntent);

                /*MyApplication myApp = (MyApplication)getApplication();
                myApp.setmGlobalString(id);

                Log.e("GlobalVariablesActivity", myApp.getmGlobalString());*/
                finish();
            }
        });

        Button btregister = (Button)findViewById(R.id.register);
        btregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(registerIntent);
            }
        });

        Button btlogin = (Button) findViewById(R.id.login);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password = passwordText.getText().toString();

                RequestBody body = new FormBody.Builder()
                        .add("password", password)
                        .build();

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://13.124.128.229:3100/login/login")
                        .post(body)
                        .build();

                client.newCall(request).enqueue(new Callback() {

                    @Override
                    public void onFailure(Call call, IOException e) {
                        finish();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        String responseData = response.body().string();


                        // wanna save the result to update UI

                        JSONObject Jobject = null;
                        try {
                            Jobject = new JSONObject(responseData);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            void updateUI(String string) {
                Handler mHandler = new Handler(Looper.getMainLooper());
            }
        });
    }
}
