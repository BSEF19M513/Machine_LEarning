package com.noman.al_quran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ReadSurah extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    ArrayList<ParaRecord> AyatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_surah);

        Intent intent = getIntent();
        int SurahID = intent.getIntExtra("SurahID", -1);
        Toast.makeText(this, "read id: " + SurahID, Toast.LENGTH_SHORT).show();
        String translation = intent.getStringExtra("Translation");
        databaseHelper = new DatabaseHelper(ReadSurah.this);
        AyatList = databaseHelper.getSurah(SurahID);

        ListView listView = findViewById(R.id.surahAyatList_listview);
        ReadParaAdapter readParaAdapter = new ReadParaAdapter(getApplicationContext(), ReadSurah.this, AyatList, translation);

        listView.setAdapter(readParaAdapter);
    }
}