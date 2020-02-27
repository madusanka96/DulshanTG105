package com.example.facebook.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyData extends SQLiteOpenHelper {

    // Database name and version(public)
    public static final String DB_NAME = "my_database_name";
    public static final int DB_VERSION = 1;

    //student table name and column names(private)
    private static final String STUDENT_TABLE = "student";

    private static final String STUDENT_NAME = "name";
    private static final String STUDENT_AGE = "age";
    private static final String STUDENT_MARKS = "marks";

    private static final String CREATE_STUDENT_TABLE = "CREATE TABLE "+STUDENT_TABLE + "("+
            STUDENT_NAME + "VARCHAR(120),"+
            STUDENT_AGE + "INTEGER, "+
            STUDENT_MARKS+ "INTEGER);";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + STUDENT_TABLE;

    private static final String  SELECT_STUDENT= "SELECT * FROM student";

    public MyData(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STUDENT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.d("hii","onCreate: "+"Database Updated Successfully");
        db.execSQL(DROP_TABLE);
        onCreate(db);


    }

    public long insertStudent(String name, int age, int marks){
        SQLiteDatabase db= getWritableDatabase();
        db.execSQL("INSERT INTO"+STUDENT_TABLE+"VALUES ('"+name+"',"+age+","+marks+")");
        db.close();
        return 0;
    }

    public void getAllStudent(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(SELECT_STUDENT, null);

        if (cursor.moveToFirst()){
            do{
                Log.d("","getAllStudent: "+
                        "Name :"+ cursor.getString(cursor.getColumnIndex(STUDENT_NAME))+
                        "Age :"+ cursor.getString(cursor.getColumnIndex(STUDENT_AGE))+
                        "Marks :"+ cursor.getString(cursor.getColumnIndex(STUDENT_MARKS)));
            }while (cursor.moveToNext());
        }

    }
}

