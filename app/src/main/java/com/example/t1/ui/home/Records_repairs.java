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

public class Records_repairs extends AppCompatActivity implements View.OnClickListener {

    private Public_Records_OpenHelper public_records_openHelper;
    private EditText et_userName_rec,et_phoneNumber_rec,et_position_rec,et_problem_rec;
    private Button btn_recordsSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records_repairs);
        init();
    }

    private void init() {
        public_records_openHelper = new Public_Records_OpenHelper(this);
        et_userName_rec = (EditText)findViewById(R.id.et_userName_rec);
        et_phoneNumber_rec = (EditText)findViewById(R.id.et_phoneNumber_rec);
        et_position_rec = (EditText)findViewById(R.id.et_position_rec);
        et_problem_rec = (EditText)findViewById(R.id.et_problem_rec);
        btn_recordsSubmit = (Button)findViewById(R.id.btn_recordsSubmit);

        btn_recordsSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String userName = et_userName_rec.getText().toString().trim();
        String phoneNumber = et_phoneNumber_rec.getText().toString().trim();
        String position = et_position_rec.getText().toString().trim();
        String problem = et_problem_rec.getText().toString().trim();
        SQLiteDatabase db = public_records_openHelper.getReadableDatabase();

        //插入数据
        ContentValues values = new ContentValues();

        values.put("userName",userName);
        values.put("phoneNumber",phoneNumber);
        values.put("position",position);
        values.put("problem",problem);
        long rowId=db.insert("PubRecords",null,values);
        if (rowId!=-1){
            Toast.makeText(this,"提交成功",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
}
