package com.recoded.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by Lenovo on 11/5/2017.
 */

public final class HabitContract {
    public final static String DATABASE_NAME = "habits.db";
    public final static int DATABASE_VERSION= 1;
    static final class HabitEntry implements BaseColumns{
        public final static String TABLE_NAME = "habits";
        public final static String TABLE_COLUMN_ID = BaseColumns._ID;
        public final static String TABLE_COLUMN_NAME = "name";
        public final static String TABLE_COLUMN_TIMES = "times";
    }
}
