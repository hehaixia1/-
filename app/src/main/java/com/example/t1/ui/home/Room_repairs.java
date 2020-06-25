package com.example.t1.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.t1.R;

public class Room_repairs extends AppCompatActivity {

    private Public_Room_OpenHelper openHelper;
    private EditText et_Roomprobem,et_phoneNumber,et_userName,et_rooms;
    private Spinner Sbuildings,Sfloors,Stypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_repairs);
        init();
        initView();
    }

    private void initView() {
        openHelper = new Public_Room_OpenHelper(this);
        Sbuildings = (Spinner)findViewById(R.id.buildings);
        Sfloors = (Spinner)findViewById(R.id.floors);
        Stypes = (Spinner)findViewById(R.id.types);
        et_rooms = (EditText)findViewById(R.id.et_rooms);
        et_phoneNumber = (EditText)findViewById(R.id.et_phoneNumber);
        et_Roomprobem = (EditText)findViewById(R.id.et_Roomproblem);
        et_userName = (EditText)findViewById(R.id.et_userName);
    }

    private void init() {
        buildings();
        floors();
        repairsType();
    }

    //所在楼栋下拉列表
    private void buildings() {
        Spinner spinner=(Spinner)findViewById(R.id.buildings);
        final String[] buildings = new String[]{"清风A","清风B","清风C","雅风A","雅风B","雅风C","惠风A","惠风B","嘉风A","嘉风B","和风A","和风B","和风C"};
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,buildings);
        spinner.setAdapter(adapter);
}

    //所在楼层下拉列表
    private void floors() {
        Spinner spinner=(Spinner)findViewById(R.id.floors);
        String[] floors = new String[]{"1楼","2楼","3楼","4楼","5楼","6楼"};
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,floors);
        spinner.setAdapter(adapter);
    }

    //选择类型下拉列表
    private void repairsType() {
        Spinner spinner=(Spinner)findViewById(R.id.types);
        String[] types = new String[]{"电器","门","家具","洁具","淋浴热水","窗户","其他"};
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,types);
        spinner.setAdapter(adapter);
    }

    //数据提交到数据库
    public void submitRepairs(View view) {
        //插入数据保存到数据库
        insertRoomRepisrs();
    }

    private void insertRoomRepisrs() {
        //三个个下拉列表读取
        String types = Stypes.getSelectedItem().toString();
        String floors = Sfloors.getSelectedItem().toString();
        String buildings = Sbuildings.getSelectedItem().toString();

        //四个EditText
        String rooms = et_rooms.getText().toString().trim();
        String phoneNumber = et_phoneNumber.getText().toString().trim();
        String userName = et_userName.getText().toString().trim();
        String problem = et_Roomprobem.getText().toString().trim();
        SQLiteDatabase db = openHelper.getReadableDatabase();

        //插入数据
        ContentValues values = new ContentValues();

        values.put("buildings",buildings);
        values.put("floors",floors);
        values.put("rooms",rooms);
        values.put("userName",userName);
        values.put("phoneNumber",phoneNumber);
        values.put("types",types);
        values.put("problem",problem);
        long rowId = db.insert("PubInformation",null,values);
        if (rowId!=-1){
            Toast.makeText(this,"提交成功",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
}
