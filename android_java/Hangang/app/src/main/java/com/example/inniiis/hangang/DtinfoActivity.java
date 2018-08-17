package com.example.inniiis.hangang;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by inniiis on 2017-06-08.
 */

public class DtinfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtinfo);

        Button call = (Button) findViewById(R.id.call);
        Button map = (Button)findViewById(R.id.map);
        Button enjoy = (Button) findViewById(R.id.enjoy);

        Intent intent = getIntent();
        int infocheck = intent.getIntExtra("infocheck", 0);

        ImageView info = (ImageView) findViewById(R.id.infoimage);
        if (infocheck == 1) {
            info.setImageResource(R.drawable.info1);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-2666-8290")); //강서
                    startActivity(intent);
                }
            });
            map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ( getPackageList() == true){
                        Uri uri = Uri.parse("geo:37.586066,126.817104?q=한강사업본부 강서안내센터");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                    else{
                        String url = "market://details?id=" + "com.nhn.android.nmap";
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(i);
                    }
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S1Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 2) {
            info.setImageResource(R.drawable.info2);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-306-0276")); //난지
                    startActivity(intent);
                }
            });map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ( getPackageList() == true){
                        Uri uri = Uri.parse("geo:37.566159,126.876344?q=난지한강공원");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                    else{
                        String url = "market://details?id=" + "com.nhn.android.nmap";
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(i);
                    }
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S2Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 3) {
            info.setImageResource(R.drawable.info3);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-2631-8290")); //양화
                    startActivity(intent);
                }
            });map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ( getPackageList() == true){
                        Uri uri = Uri.parse("geo:37.541295,126.898095?q=양화한강공원");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                    else{
                        String url = "market://details?id=" + "com.nhn.android.nmap";
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(i);
                    }
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S3Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 4) {
            info.setImageResource(R.drawable.info4);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-333-4125")); //망원
                    startActivity(intent);
                }
            });
            map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ( getPackageList() == true){
                        Uri uri = Uri.parse("geo:37.555735,126.894570?q=망원한강공원");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                    else{
                        String url = "market://details?id=" + "com.nhn.android.nmap";
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(i);
                    }
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S4Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 5) {
            info.setImageResource(R.drawable.info5);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-782-2895")); //여의도
                    startActivity(intent);
                }
            });
            map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ( getPackageList() == true){
                        Uri uri = Uri.parse("geo:37.527337,126.934939?q=여의도한강공원");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                    else{
                        String url = "market://details?id=" + "com.nhn.android.nmap";
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(i);
                    }
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S5Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 6) {
            info.setImageResource(R.drawable.info6);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-790-1891")); //이촌
                    startActivity(intent);
                }
            });
            map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ( getPackageList() == true){
                        Uri uri = Uri.parse("geo:37.515949,126.975832?q=이촌한강공원");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                    else{
                        String url = "market://details?id=" + "com.nhn.android.nmap";
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(i);
                    }
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S6Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 7) {
            info.setImageResource(R.drawable.info7);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-591-5943")); //반포
                    startActivity(intent);
                }
            });
            map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ( getPackageList() == true){
                        Uri uri = Uri.parse("geo:37.511581,126.997710?q=반포한강공원.세빛섬");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                    else{
                        String url = "market://details?id=" + "com.nhn.android.nmap";
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(i);
                    }
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S7Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 8) {
            info.setImageResource(R.drawable.info8);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-534-3263")); //잠원
                    startActivity(intent);
                }
            });
            map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ( getPackageList() == true){
                        Uri uri = Uri.parse("geo:37.519439,127.009896?q=잠원한강공원");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                    else{
                        String url = "market://details?id=" + "com.nhn.android.nmap";
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(i);
                    }
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S8Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 9) {
            info.setImageResource(R.drawable.info9);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-3780-0521")); //뚝섬
                    startActivity(intent);
                }
            });
            map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ( getPackageList() == true){
                        Uri uri = Uri.parse("geo:37.529105,127.071329?q=뚝섬한강공원");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                    else{
                        String url = "market://details?id=" + "com.nhn.android.nmap";
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(i);
                    }
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S9Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 10) {
            info.setImageResource(R.drawable.info10);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-417-1348")); //잠실
                    startActivity(intent);
                }
            });
            map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ( getPackageList() == true){
                        Uri uri = Uri.parse("geo:37.517968,127.081954?q=잠실한강공원");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                    else{
                        String url = "market://details?id=" + "com.nhn.android.nmap";
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(i);
                    }
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S10Activity.class);
                    startActivity(intent);
                }
            });
        }
        if (infocheck == 11) {
            info.setImageResource(R.drawable.info11);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-485-3091")); //광나루
                    startActivity(intent);
                }
            });
            map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ( getPackageList() == true){
                        Uri uri = Uri.parse("geo:37.549992,127.121633?q=광나루한강공원");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                    else{
                        String url = "market://details?id=" + "com.nhn.android.nmap";
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(i);
                    }
                }
            });
            enjoy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DtinfoActivity.this, S11Activity.class);
                    startActivity(intent);
                }
            });
        }

    }
    public boolean getPackageList() {
        boolean isExist = false;

        PackageManager pkgMgr = getPackageManager();
        List<ResolveInfo> mApps;
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        mApps = pkgMgr.queryIntentActivities(mainIntent, 0);

        try {
            for (int i = 0; i < mApps.size(); i++) {
                if(mApps.get(i).activityInfo.packageName.startsWith("com.nhn.android.nmap")){
                    isExist = true;
                    break;
                }
            }
        }
        catch (Exception e) {
            isExist = false;
        }
        return isExist;
    }
}
