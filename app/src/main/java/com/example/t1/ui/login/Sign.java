package com.example.t1.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.t1.R;

public class Sign extends AppCompatActivity implements View.OnClickListener {
    private String realCode;
    private DBOpenHelper mDBOpenHelper;
    private Button mBtnSign;
    private ImageView mIvShowCode;
    private EditText mEtUsername;
    private EditText mEtPassword1;
    private EditText mEtPassword2;
    private EditText mEtCodes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        init();

        mDBOpenHelper = new DBOpenHelper(this);

        //将验证码用图片的形式显示出来
        mIvShowCode.setImageBitmap(Code.getInstance().createBitmap());
        realCode = Code.getInstance().getCode().toLowerCase();
    }

    private void init() {
        mBtnSign = findViewById(R.id.btn_sign);
        mIvShowCode = findViewById(R.id.iv_showCode);
        mEtUsername = findViewById(R.id.et_username_sign);
        mEtPassword1 = findViewById(R.id.et_password_one);
        mEtPassword2 = findViewById(R.id.et_password_two);
        mEtCodes = findViewById(R.id.et_showCode);

        mBtnSign.setOnClickListener(this);
        mIvShowCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_showCode:
                mIvShowCode.setImageBitmap(Code.getInstance().createBitmap());
                realCode = Code.getInstance().getCode().toLowerCase();
                break;
            case R.id.btn_sign:
                //获取用户输入的用户名、密码、验证码
                String username = mEtUsername.getText().toString().trim();
                String password = mEtPassword2.getText().toString().trim();
                String phoneCode = mEtCodes.getText().toString().toLowerCase();
                //注册验证
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(phoneCode) ) {
                    if (phoneCode.equals(realCode)) {
                        //将用户名和密码加入到数据库中
                        mDBOpenHelper.add(username, password);
                        Intent intent2 = new Intent(this, Login.class);
                        startActivity(intent2);
                        finish();
                        Toast.makeText(this,  "验证通过，注册成功,请登录。", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "验证码错误,注册失败", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, "未完善信息，注册失败", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
}
