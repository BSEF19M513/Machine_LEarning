package com.noman.al_quran;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "data.sqlite";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public String demo() {
        String query = "SELECT * FROM tsurah";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        String value = "default";
        if(cursor.moveToFirst()) {
            value = cursor.getString(2);
        }
        db.close();
        return value;
    }

    public ArrayList<ParaRecord> getParaAyat(int ParaID) {
        String query = "SELECT * FROM tayah WHERE ParaID=" + ParaID + " ORDER BY AyaID";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<ParaRecord> AyatList = new ArrayList<>();
        if(cursor.moveToFirst()) {
            do {
                ParaRecord paraRecord = new ParaRecord(cursor.getInt(10), cursor.getInt(0), cursor.getString(3), cursor.getString(4),cursor.getString(5), cursor.getString(6), cursor.getString(7));
                AyatList.add(paraRecord);
            } while(cursor.moveToNext());
        }
        db.close();
        return AyatList;
    }

    public ArrayList<SurahRecord> getAllSurah() {
        String query = "SELECT * FROM tsurah ORDER BY SurahID";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<SurahRecord> surahRecords = new ArrayList<>();
        if(cursor.moveToFirst()) {
            do {
                SurahRecord surahRecord = new SurahRecord(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(4),cursor.getString(3));
                surahRecords.add(surahRecord);
            } while(cursor.moveToNext());
        }
        db.close();
        return surahRecords;
    }

    public ArrayList<ParaRecord> getSurah(int SurahID) {
        String query = "SELECT * FROM tayah WHERE SuraID=" + SurahID + " ORDER BY AyaID";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<ParaRecord> AyatList = new ArrayList<>();
        if(cursor.moveToFirst()) {
            do {
                ParaRecord paraRecord = new ParaRecord(cursor.getInt(10), cursor.getInt(0), cursor.getString(3), cursor.getString(4),cursor.getString(5), cursor.getString(6), cursor.getString(7));
                AyatList.add(paraRecord);
            } while(cursor.moveToNext());
        }
        db.close();
        return AyatList;
    }



}

