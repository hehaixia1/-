package com.example.t1.ui.setting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.t1.R;

public class FillInformation extends AppCompatActivity {

    private EditText userName_fill;
    private EditText phoneNumber_fill;
    private EditText academy_fill;
    private EditText grade_fill;
    private EditText major_fill;
    private EditText address_fill;
    private InformationHelper informationHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_information);
        init();
    }

    private void init() {
        informationHelper = new InformationHelper(this);
        userName_fill = (EditText)findViewById(R.id.et_userName_fill);
        phoneNumber_fill = (EditText)findViewById(R.id.et_phoneNumber_fill);
        academy_fill = (EditText)findViewById(R.id.et_academy_fill);
        grade_fill = (EditText)findViewById(R.id.et_grade_fill);
        major_fill = (EditText)findViewById(R.id.et_major_fill);
        address_fill = (EditText)findViewById(R.id.et_address_fill);
    }

    public void saveInformation(View view) {
        insertInformation();
    }
    //读取数据
    private void insertInformation() {

        String userName = userName_fill.getText().toString().trim();
        String phoneNumber = phoneNumber_fill.getText().toString().trim();
        String academy = academy_fill.getText().toString().trim();
        String grade = grade_fill.getText().toString().trim();
        String major = major_fill.getText().toString().trim();
        String address = address_fill.getText().toString().trim();
        SQLiteDatabase db = informationHelper.getReadableDatabase();

        //插入数据
        ContentValues values = new ContentValues();

        values.put("userName",userName);
        values.put("phoneNumber",phoneNumber);
        values.put("academy",academy);
        values.put("grade",grade);
        values.put("major",major);
        values.put("address",address);

        long rowId = db.insert("Information",null,values);
        if (rowId!=-1){
            Toast.makeText(this,"提交成功",Toast.LENGTH_SHORT).show();
        }
        db.close();

    }


}
