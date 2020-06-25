package com.example.t1.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.t1.R;

public class Public_repairs extends AppCompatActivity {

    private Public_Repairs_OpenHelper public_repairs_openHelper;
    private EditText et_userName_pub,et_phoneNumber_pub,et_position_pub,et_problem_pub;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_repairs);
        init();

    }

    private void init() {
        public_repairs_openHelper = new Public_Repairs_OpenHelper(this);
        et_phoneNumber_pub = (EditText)findViewById(R.id.et_phoneNumber_pub);
        et_position_pub = (EditText)findViewById(R.id.et_position_pub);
        et_userName_pub = (EditText)findViewById(R.id.et_userName_pub);
        et_problem_pub = (EditText)findViewById(R.id.et_problem_pub);
    }

    public void submitRepairs(View view) {
        String userName = et_userName_pub.getText().toString().trim();
        String phoneNumber = et_phoneNumber_pub.getText().toString().trim();
        String position = et_position_pub.getText().toString().trim();
        String problem = et_problem_pub.getText().toString().trim();
        SQLiteDatabase db = public_repairs_openHelper.getReadableDatabase();

        //插入数据
        ContentValues values = new ContentValues();

        values.put("userName",userName);
        values.put("phoneNumber",phoneNumber);
        values.put("position",position);
        values.put("problem",problem);
        long rowId=db.insert("PubRepairs",null,values);
        if (rowId!=-1){
            Toast.makeText(this,"提交成功",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

}
