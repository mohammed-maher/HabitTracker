package com.recoded.habittracker;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.recoded.habittracker.data.HabitContract;
import com.recoded.habittracker.data.HabitSqliteHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitSqliteHelper dbHelper = new HabitSqliteHelper(this);
        dbHelper.insertData("Watch Udacity",10);
        dbHelper.insertData("Listen to music",2);
        Cursor c = dbHelper.getData();
    }
}
