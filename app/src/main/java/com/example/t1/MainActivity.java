package com.example.t1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.t1.ui.home.Public_repairs;
import com.example.t1.ui.home.Records_repairs;
import com.example.t1.ui.home.Room_clear;
import com.example.t1.ui.home.Room_repairs;
import com.example.t1.ui.login.User;
import com.example.t1.ui.notifications.OrderWater;
import com.example.t1.ui.notifications.UserHelp;
import com.example.t1.ui.setting.About;
import com.example.t1.ui.setting.AllRecords;
import com.example.t1.ui.setting.CallPhone;
import com.example.t1.ui.setting.FillInformation;
import com.example.t1.ui.setting.InformationHelper;
import com.example.t1.ui.setting.Settings;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private TextView tv_userName_show,tv_phoneNumber_show;
    private SQLiteDatabase database;
    private InformationHelper informationHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.main);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications,
                R.id.setting
        )
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
    //报修模块
    //宿舍报修响应
    public void roomRepairs(View view) {
        Intent intent=new Intent(MainActivity.this, Room_repairs.class);
        startActivity(intent);
    }
    //公共报修响应
    public void publicRepairs(View view) {
        Intent intent = new Intent(MainActivity.this, Public_repairs.class);
        startActivity(intent);
    }
    //我要报事响应
    public void records(View view) {
        Intent intent = new Intent(MainActivity.this, Records_repairs.class);
        startActivity(intent);
    }
    //公寓清洁响应
    public void roomClearShow(View view) {
        Intent intent = new Intent(MainActivity.this, Room_clear.class);
        startActivity(intent);
    }

    //服务模块
    //桶装水订购
    public void orderWater(View view) {
        Intent intent = new Intent(MainActivity.this, OrderWater.class);
        startActivity(intent);
    }
    //help
    public void help(View view) {
        Intent intent = new Intent(MainActivity.this, UserHelp.class);
        startActivity(intent);
    }
    //我的__设置板块
    //报修记录响应
    public void allRecords(View view){
        Intent intent = new Intent(MainActivity.this, AllRecords.class);
        startActivity(intent);
    }
    //响应客服电话
    public void callPhone(View view){
        Intent intent = new Intent(MainActivity.this, CallPhone.class);
        startActivity(intent);
    }
    //响应关于
    public void aboutApp(View view){
        Intent intent = new Intent(MainActivity.this, About.class);
        startActivity(intent);
    }
    //响应设置
    public void settings(View view){
        Intent intent = new Intent(MainActivity.this, Settings.class);
        startActivity(intent);
    }
    //完善资料
    public void fillInformation(View view){
        Intent intent = new Intent(MainActivity.this, FillInformation.class);
        startActivity(intent);
    }
    //资料卡的显示
    public void showInformation(View view){

        tv_phoneNumber_show = (TextView)findViewById(R.id.tv_phoneNumber_show);
        tv_userName_show = (TextView)findViewById(R.id.tv_userName_show);

        informationHelper = new InformationHelper(this);
        database = informationHelper.getReadableDatabase();
        Cursor cur = database.query("Information",null,null,null,null,null,null);
        cur.moveToFirst();

        tv_userName_show.setText(cur.getString(cur.getColumnIndex("userName")));
        tv_phoneNumber_show.setText(cur.getString(cur.getColumnIndex("phoneNumber")));

        cur.close();

    }


}
