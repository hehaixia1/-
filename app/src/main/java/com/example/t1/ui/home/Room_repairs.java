package com.example.t1.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.example.t1.R;

public class Room_repairs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_repairs);
        init();
    }

    private void init() {
        buildings();
        floors();
        rooms();
        repairsType();
    }

    //所在楼栋下拉列表
    private void buildings() {
        Spinner spinner=(Spinner)findViewById(R.id.buildings);
        String[] rooms = new String[]{"清风A","清风B","清风C"};
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,rooms);
        spinner.setAdapter(adapter);
    }
    //所在楼层下拉列表
    private void floors() {
        Spinner spinner=(Spinner)findViewById(R.id.floors);
        String[] rooms = new String[]{"1楼","2楼","3楼","4楼","5楼","6楼"};
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,rooms);
        spinner.setAdapter(adapter);
    }
    //所在房间下拉列表
    private void rooms() {
        Spinner spinner=(Spinner)findViewById(R.id.rooms);
        String[] rooms = new String[]{"清风A","清风B","清风C"};
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,rooms);
        spinner.setAdapter(adapter);
    }
    //所在房间下拉列表
    private void repairsType() {
        Spinner spinner=(Spinner)findViewById(R.id.repairs_types);
        String[] rooms = new String[]{"电器","门","家具","洁具","淋浴热水","窗户","其他"};
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,rooms);
        spinner.setAdapter(adapter);
    }
}
