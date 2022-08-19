package com.example.crud;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tableStatement = "Create Table Records (NAME Text, ID Text,SECTION Text)";
        sqLiteDatabase.execSQL(tableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Records");
    }

    public DBHelper(Context context)
    {
        super(context, "MyDB.db", null, 1);
    }

    public Boolean insertRecord(String name, String id, String section)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME", name);
        values.put("ID", id);
        values.put("SECTION", section);

        long res = database.insert("Records", null, values);
        if (res==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Cursor viewRecords()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from Records", null);
        return cursor;
    }

    public Boolean updateRecord(String name, String id, String section)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("ID", id);
        contentValues.put("SECTION", section);
        Cursor cursor = DB.rawQuery("Select * from Records where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.update("Records", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    
}