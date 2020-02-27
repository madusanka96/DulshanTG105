package com.example.facebook.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.util.Log;

import androidx.annotation.Nullable;

import static android.content.ContentValues.TAG;

public class MyData extends SQLiteOpenHelper {


    public static final String DB_NAME = "myDB.db";
    public static final int DB_VERSION=1;
    public static final String TABLE_NAME="student_details";
    public static final String COLUMN_1="stu_name";
    public static final String COLUMN_2="stu_age";
    public static final String COLUMN_3="stu_marks";




    SQLiteDatabase database;



    public MyData(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG ,"onCreate: " + " Database Created.. ");
        db.execSQL("create table "+TABLE_NAME+"(id integer primary key autoincrement,name TEXT,age integer,marks integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG ,"onCreate: " + " Database Updated ");
        db.execSQL("DROP TABLE IF EXISTS "+DB_NAME);
        onCreate(db);
    }

    public boolean insertData(String stu_name,String stu_age,String stu_mark){
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_1,stu_name);
        contentValues.put(COLUMN_2,stu_age);
        contentValues.put(COLUMN_3,stu_mark);

        long data = db.insert(TABLE_NAME,null,contentValues);

        if (data==-1)
            return false;
        else
            return true;
    }

    public Cursor getAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("select * from "+TABLE_NAME,null);
        return  data;
    }
}
