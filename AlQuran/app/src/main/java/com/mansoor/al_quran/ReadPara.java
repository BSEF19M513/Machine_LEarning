package com.noman.al_quran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ReadPara extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    ArrayList<ParaRecord> AyatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_para);

        Intent intent = getIntent();
        int ParaID = intent.getIntExtra("ParaID", -1);
        String translation = intent.getStringExtra("Translation");
        Toast.makeText(this, translation, Toast.LENGTH_SHORT).show();
        databaseHelper = new DatabaseHelper(ReadPara.this);
        AyatList = databaseHelper.getParaAyat(ParaID);

        ListView listView = findViewById(R.id.paraAyatList_listview);
        ReadParaAdapter readParaAdapter = new ReadParaAdapter(getApplicationContext(), ReadPara.this, AyatList, translation);

        listView.setAdapter(readParaAdapter);
    }
}