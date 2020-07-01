package com.example.t1.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.t1.R;

public class Room_clear extends AppCompatActivity implements View.OnClickListener {

    private EditText et_suggestion;
    private Button btn_submit_clear;
    private Public_Clear_OpenHelper public_clear_openHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_clear);
        init();

    }

    private void init() {
        public_clear_openHelper = new Public_Clear_OpenHelper(this);
        et_suggestion = (EditText)findViewById(R.id.et_suggestion);
        btn_submit_clear = (Button)findViewById(R.id.btn_submit_clear);

        btn_submit_clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String suggestion = et_suggestion.getText().toString().trim();
        SQLiteDatabase db = public_clear_openHelper.getReadableDatabase();
        //插入数据
        ContentValues values = new ContentValues();

        values.put("suggestion",suggestion);
        long rowId = db.insert("Suggestion",null,values);
        if(rowId!=-1){
            Toast.makeText(this,"提交成功",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
}
