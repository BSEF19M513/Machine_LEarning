package com.noman.al_quran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class ReadBySurah extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    ArrayList<SurahRecord> surahRecords;
    ArrayList<SurahRecord> surahRecordsFiltered = new ArrayList<>();
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_by_surah);

        databaseHelper = new DatabaseHelper(ReadBySurah.this);
        surahRecords = databaseHelper.getAllSurah();
        filterRecords("");

        editText = findViewById(R.id.searchText);
        listView = findViewById(R.id.surahlist_listview);
        ReadBySurahAdapter readBySurahAdapter = new ReadBySurahAdapter(getApplicationContext(), ReadBySurah.this,surahRecordsFiltered);
        listView.setAdapter(readBySurahAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =  new Intent(ReadBySurah.this, SurahTranslationOptions.class);
                intent.putExtra("SurahID", surahRecords.get(i).getSurahID());
                startActivity(intent);
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                filterRecords(editText.getText().toString());
                readBySurahAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void filterRecords(String searchText) {
        surahRecordsFiltered.removeAll(surahRecordsFiltered);

        for(int i=0;i<surahRecords.size();i++) {
            if(
                    surahRecords.get(i).getSurahNameE().toLowerCase(Locale.ROOT).indexOf(searchText.toLowerCase(Locale.ROOT)) != -1 ||
                            surahRecords.get(i).getSurahNameU().indexOf(searchText) != -1 || Integer.toString(surahRecords.get(i).getSurahID()).indexOf(searchText) != -1

            ) {
                surahRecordsFiltered.add(surahRecords.get(i));
            }
        }
    }
}