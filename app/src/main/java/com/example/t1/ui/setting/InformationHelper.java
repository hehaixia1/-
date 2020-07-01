package com.example.t1.ui.setting;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class InformationHelper extends SQLiteOpenHelper {

    //创建sdk自带的数据库变量
    private SQLiteDatabase db;
    public InformationHelper(Context context){
        super(context,"Information.db",null,1);
        db = getReadableDatabase();
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE IF NOT EXISTS Information(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "userName," +
                "phoneNumber," +
                "academy," +
                "grade," +
                "major," +
                "address)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
