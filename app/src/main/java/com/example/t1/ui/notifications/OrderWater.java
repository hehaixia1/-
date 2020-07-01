package com.example.t1.ui.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.t1.R;


public class OrderWater extends AppCompatActivity implements View.OnClickListener {

    private OrderWater_OpenHelper orderWater_openHelper;
    private EditText et_phoneNumber_water,et_userName_water,et_rooms_water;
    private Spinner Sbuildings_water,Sfloors_water,Samount_water;
    private Button btn_OrderWater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_water);
        init();
        initView();
    }

    private void initView() {
        orderWater_openHelper = new OrderWater_OpenHelper(this);

        et_phoneNumber_water = (EditText)findViewById(R.id.et_phoneNumber_water);
        et_rooms_water = (EditText)findViewById(R.id.et_rooms_water);
        et_userName_water = (EditText)findViewById(R.id.et_rooms_water);

        Sbuildings_water = (Spinner)findViewById(R.id.buildings_water);
        Sfloors_water = (Spinner)findViewById(R.id.floors_water);
        Samount_water = (Spinner)findViewById(R.id.amount_water);

        btn_OrderWater = (Button)findViewById(R.id.btn_orderWater);
        btn_OrderWater.setOnClickListener(this);
    }

    private void init() {
        buildings();
        floors();
        repairsType();

    }

    //所在楼栋下拉列表
    private void buildings() {
        Spinner spinner=(Spinner)findViewById(R.id.buildings_water);
        final String[] buildings = new String[]{"清风A","清风B","清风C","雅风A","雅风B","雅风C","惠风A","惠风B","嘉风A","嘉风B","和风A","和风B","和风C"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,buildings);
        spinner.setAdapter(adapter);
    }

    //所在楼层下拉列表
    private void floors() {
        Spinner spinner=(Spinner)findViewById(R.id.floors_water);
        String[] floors = new String[]{"1楼","2楼","3楼","4楼","5楼","6楼"};
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,floors);
        spinner.setAdapter(adapter);
    }

    //选择类型下拉列表
    private void repairsType() {
        Spinner spinner=(Spinner)findViewById(R.id.amount_water);
        String[] types = new String[]{"1桶","2桶","3桶","4桶"};
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,types);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        insertOrderWater();
    }

    private void insertOrderWater() {

        String floors = Sfloors_water.getSelectedItem().toString();
        String buildings = Sbuildings_water.getSelectedItem().toString();
        String amounts = Samount_water.getSelectedItem().toString();

        String rooms = et_rooms_water.getText().toString().trim();
        String phoneNumber = et_phoneNumber_water.getText().toString().trim();
        String userName = et_userName_water.getText().toString().trim();
        SQLiteDatabase db = orderWater_openHelper.getReadableDatabase();

        //插入数据
        ContentValues values = new ContentValues();

        values.put("buildings",buildings);
        values.put("floors",floors);
        values.put("rooms",rooms);
        values.put("userName",userName);
        values.put("phoneNumber",phoneNumber);
        values.put("amount",amounts);

        long rowId = db.insert("OrderWater",null,values);
        if (rowId!=-1){
            Toast.makeText(this,"提交成功",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
}
