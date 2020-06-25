package com.example.t1.ui.setting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.t1.R;
import com.example.t1.ui.home.Public_Room_OpenHelper;


public class AllRecords extends AppCompatActivity {

    public Public_Room_OpenHelper openHelper;
    public ListView lstPubInformation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_records);
        init();
        queryInformation();
    }

    private void queryInformation() {
        SQLiteDatabase db = openHelper.getReadableDatabase();
        Cursor cur = db.query(
                "PubInformation",
                null,
                null,
                null,
                null,
                null,
                null
        );
        //设置适配器
        CursorAdapter adapter = new CursorAdapter(this,cur) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                View view = LayoutInflater.from(AllRecords.this).inflate(R.layout.pubinformation_item,null);
                return view;
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView tvTypes = (TextView) view.findViewById(R.id.tv_types);
                TextView tvProblem = (TextView) view.findViewById(R.id.tv_problem);

                int columnIndex = cursor.getColumnIndex("types");
                String position = cursor.getString(columnIndex);

                int columnIndex2 = cursor.getColumnIndex("problem");
                String problem = cursor.getString(columnIndex2);

                //显示设置
                tvTypes.setText(position);
                tvProblem.setText(problem);
            }
        };
        lstPubInformation.setAdapter(adapter);
    }

    private void init() {
       openHelper = new Public_Room_OpenHelper(this);
       lstPubInformation = (ListView) findViewById(R.id.list_item);

    }
}
