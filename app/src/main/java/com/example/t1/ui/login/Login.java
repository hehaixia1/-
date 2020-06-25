package com.example.t1.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.t1.MainActivity;
import com.example.t1.R;

import java.util.ArrayList;

public class Login extends AppCompatActivity implements View.OnClickListener {

    //自己写的DBOpenHelper对象，用来创建数据库，对数据表进行增删查改工作
    private DBOpenHelper mDBOpenHelper;
    private EditText mLoginUsername;
    private EditText mLoginPaswd;
    private Button mLogin;
    private TextView mSign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        mDBOpenHelper = new DBOpenHelper(this);
    }

    private void init() {
        //初始化控件
        mLoginUsername = findViewById(R.id.et_login_username);
        mLoginPaswd = findViewById(R.id.et_login_password);
        mLogin = findViewById(R.id.btn_login);
        mSign = findViewById(R.id.tv_sign);

        //设置时间的监听
        mLogin.setOnClickListener(this);
        mSign.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //跳转到注册页面
            case R.id.tv_sign:
                Intent intent = new Intent(this,Sign.class);
                startActivity(intent);
                finish();
                break;
            //登录验证
            case R.id.btn_login:
                //获取文本编辑框的内容，并且去掉两边的空格
                String userName = mLoginUsername.getText().toString().trim();
                String passWord = mLoginPaswd.getText().toString().trim();
                //判断账号密码是否为空
                if(!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(passWord)){
                    ArrayList<User> data = mDBOpenHelper.getAllData();
                    boolean match = false;
                    for (int i = 0; i <data.size(); i++) {
                        User user = data.get(i);
                        if (userName.equals(user.getUserName()) && passWord.equals(user.getPassword())){
                            match = true;
                            break;
                        }else{
                            match = false;
                        }
                    }
                    if(match){
                        //登陆成功跳转页面
                        Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();
                        Intent intent_login = new Intent(this, MainActivity.class);
                        startActivity(intent_login);
                        finish();//销毁此activity
                    }else{
                        Toast.makeText(this,"用户名或者秘密输入不正确，请重新输入",Toast.LENGTH_SHORT).show();

                    }
                }else{
                    Toast.makeText(this,"请输入你的用户名或者密码",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
