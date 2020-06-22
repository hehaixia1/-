package com.example.t1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.t1.ui.home.Public_repairs;
import com.example.t1.ui.home.Records_repairs;
import com.example.t1.ui.home.Room_repairs;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

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
}
