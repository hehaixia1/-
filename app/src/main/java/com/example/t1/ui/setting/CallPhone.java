package com.example.t1.ui.setting;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.t1.R;

public class CallPhone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_phone);
    }
    private void init() {
        String phoneNumber = "15320217230";
        //设置打电话的意图
        Intent intent = new Intent(Intent.ACTION_DIAL);
        //设置的电话的电话号码
        Uri data = Uri.parse("tel:" + phoneNumber);
        intent.setData(data);
        startActivity(intent);
    }

    public void callPhone(View view) {
        init();
    }
}
