package com.example.inniiis.hangang;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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

/**
 * Created by inniiis on 2017-06-08.
 */

public class RegisterActivity extends AppCompatActivity {
    private AlertDialog dialog;
    private boolean validate = false;
    //private static final String TAG = "RegisterActivity";
    // private HttpConnection httpConn = HttpConnection.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button back = (Button) findViewById(R.id.back);

        final EditText idText = (EditText) findViewById(R.id.id);
        final EditText nameText = (EditText) findViewById(R.id.name);
        final EditText passwordText = (EditText) findViewById(R.id.password);
        final EditText password2Text = (EditText) findViewById(R.id.password2);
        final EditText phoneText = (EditText) findViewById(R.id.phone);

        Button registerButton = (Button) findViewById(R.id.register);
        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String id = idText.getText().toString();
                String name = nameText.getText().toString();
                String password = passwordText.getText().toString();
                String password2 = password2Text.getText().toString();
                String phone = phoneText.getText().toString();

              /*  if (!validate) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog = builder.setMessage("먼저 중복체크를 해주세요.")
                            .setPositiveButton("확인", null).create();
                    dialog.show();
                    return;
                }*/

                RequestBody body = new FormBody.Builder()
                        .add("id", id)
                        .add("username", name)
                        .add("password", password)
                        .add("phoneNum", phone)
                        .build();

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://13.124.128.229:3100/signup/up")
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
        });
    }
    public void btback(View view) {
        finish();
    }

}