package test.parkingreservation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by baehw_000 on 2017-06-18.
 */

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}