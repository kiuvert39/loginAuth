package com.example.first;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLitedb extends SQLiteOpenHelper {
    private  Context context;
    private  static final String DATABASE_NAME = "Login.Db";
    private static final  int DATABASE_VERSION = 1;
    private static  final String TABLE_NAME = "LOGIN_DETAILS";
    private  static  final String COLUMN_ID = "_id";
    private static  final String COLUMN_NAME = "name";
    private static  final String COLUMN_EMAIL = "email";
    private  static  final String COLUMN_PASSWORD =  "password";
    public SQLitedb(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_PASSWORD+ " TEXT);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    //inserting users

    public  Boolean insertData( String name, String password){
        SQLiteDatabase   DATABASE_NAME = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_PASSWORD, password);
        long result = DATABASE_NAME.insert(TABLE_NAME, null, contentValues);
        if(result== -1) return false;
        else
            return true;
    }

    public Boolean checkName(String name){
        SQLiteDatabase   DATABASE_NAME = this.getWritableDatabase();
        Cursor cursor = DATABASE_NAME.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE name = ?", new String[]{name});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    //checking name and password

    public Boolean checkNamePassword(String name, String password){
        SQLiteDatabase DATABASE_NAME = this.getWritableDatabase();
        Cursor cursor = DATABASE_NAME.rawQuery("Select * from users where username = ? and password = ?", new String[]{name,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }
}
