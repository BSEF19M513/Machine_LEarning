package com.example.welcome;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "myDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("create Table Records (NAME text, EMAIL text PRIMARY KEY, PASSWORD text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {
        database.execSQL("drop table  if exists Records");
    }

    Boolean addRecord(String name, String email, String password)
    {
        SQLiteDatabase database = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME", name);
        values.put("EMAIL", email);
        values.put("PASSWORD", password);

        Long result = database.insert("Records", null, values);
        if(result==-1)
        {
            return  false;
        }
        else
        {
            return  true;
        }
    }
}
