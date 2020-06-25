package com.example.t1.ui.home;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Public_Records_OpenHelper extends SQLiteOpenHelper {

    //创建sdk自带的数据库变量
    private SQLiteDatabase db;
    public Public_Records_OpenHelper(Context context){
        super(context,"PubRecords.db",null,1);
        db = getReadableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE IF NOT EXISTS PubRecords(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "userName," +
                "phoneNumber," +
                "position," +
                "problem)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
