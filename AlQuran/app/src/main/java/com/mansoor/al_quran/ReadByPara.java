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
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;

public class ReadByPara extends AppCompatActivity {

    int[] ParaList = new int[30];
    ArrayList<String> ParaListAsParameters = new ArrayList<String>();

    ListView listView;
    EditText editText;

    String[] englishParahNames;
    ArrayList<String> englishParahNamesAsParameter = new ArrayList<String>();

    String[] urduParahNames;
    ArrayList<String> urduParahNamesAsParameter = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_by_para);
        for(int i=0;i<30;i++) {
            ParaList[i] = i+1;
        }
        initializeParaNames();
        filterRecords("");

        editText = findViewById(R.id.searchText);
        listView = findViewById(R.id.paralist_listview);
        ReadByParaAdapter readByParaAdapter = new ReadByParaAdapter(getApplicationContext(), ReadByPara.this, ParaListAsParameters, englishParahNamesAsParameter, urduParahNamesAsParameter);

        listView.setAdapter(readByParaAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =  new Intent(ReadByPara.this, ParaTranslationOptions.class);
                intent.putExtra("ParaID", i+1);
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
                readByParaAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }

    private void initializeParaNames() {
        String[] englishParahName = {"Alif Lam Meem",
                "Sayaqool ",
                "Tilkal Rusull",
                "Lan Tana Loo",
                "Wal Mohsanat",
                "La Yuhibbullah",
                "Wa Iza Samiu",
                "Wa Lau Annana",
                "Qalal Malao",
                "Wa A'lamu",
                "Yatazeroon ",
                "Wa Mamin Da'abat",
                "Wa Ma Ubrioo",
                "Rubama",
                "Subhanallazi",
                "Qal Alam",
                "Aqtarabo",
                "Qadd Aflaha",
                "Wa Qalallazina",
                "A'man Khalaq",
                "Utlu Ma Oohi",
                "Wa Manyaqnut",
                "Wa Mali",
                "Faman Azlam",
                "Elahe Yuruddo",
                "Ha'a Meem",
                "Qala Fama Khatbukum",
                "Qadd Sami Allah",
                "Tabarakallazi",
                "Amma Yatasa'aloon",
        };
        String[] urduParahName = {"الم ",
                "سیقول ",
                "تلک الرسل ",
                "لن تنالوالبر",
                "والمحصنت",
                "لایحب اللہ ",
                "واذاسمعوا",
                "ولواننا",
                "قال الملاء",
                "واعلموا",
                "یعتذرون ",
                "ومامن دآبۃ",
                "وماابرئ",
                "ربما",
                "سبحن الذی ",
                "قال الم ",
                "اقترب للناس",
                "قد افلح",
                "وقال الذین ",
                "امن خلق",
                "اتل مااوحی",
                "ومن یقنت ",
                "ومالی ",
                "فمن اظلم ",
                "الیہ یرد",
                "حم ",
                "قال فماخطبکم ",
                "قدسمع اللہ ",
                "تبارک الذی ",
                "عم یتسآءلون ",
        };
        this.englishParahNames = englishParahName;
        this.urduParahNames = urduParahName;
    }

    private void filterRecords(String searchText) {
        englishParahNamesAsParameter.removeAll(englishParahNamesAsParameter);
        urduParahNamesAsParameter.removeAll(urduParahNamesAsParameter);
        ParaListAsParameters.removeAll(ParaListAsParameters);

        for(int i=0;i<ParaList.length;i++) {
            if(
                    englishParahNames[i].toLowerCase(Locale.ROOT).indexOf(searchText.toLowerCase(Locale.ROOT)) != -1 ||
                            urduParahNames[i].indexOf(searchText) != -1 || Integer.toString(ParaList[i]).indexOf(searchText) != -1

            ) {
                englishParahNamesAsParameter.add(englishParahNames[i]);
                urduParahNamesAsParameter.add(urduParahNames[i]);
                ParaListAsParameters.add(Integer.toString(ParaList[i]));
            }
        }
    }
}