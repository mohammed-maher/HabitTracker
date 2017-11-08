package com.recoded.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lenovo on 11/5/2017.
 */

public class HabitSqliteHelper extends SQLiteOpenHelper {

    public HabitSqliteHelper(Context context) {
        super(context, HabitContract.DATABASE_NAME, null, HabitContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       final String CREATE_SQL_ENTRIES = "CREATE TABLE "+ HabitContract.HabitEntry.TABLE_NAME+" ("+
                HabitContract.HabitEntry.TABLE_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                HabitContract.HabitEntry.TABLE_COLUMN_NAME+" TEXT, "+
                HabitContract.HabitEntry.TABLE_COLUMN_TIMES+" INTEGER);";

       sqLiteDatabase.execSQL(CREATE_SQL_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + HabitContract.HabitEntry.TABLE_NAME;
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name,int times){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.TABLE_COLUMN_NAME, name);
        values.put(HabitContract.HabitEntry.TABLE_COLUMN_TIMES, times);
        long newRowId = db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);
        return newRowId != -1;
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {
                HabitContract.HabitEntry.TABLE_COLUMN_ID
        };

        String selection = HabitContract.HabitEntry.TABLE_COLUMN_ID + " = ?";
        String[] selectionArgs = { "1" };

        Cursor cursor = db.query(
                HabitContract.HabitEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        return cursor;
    }
}
