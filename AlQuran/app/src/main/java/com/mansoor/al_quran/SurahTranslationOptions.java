package com.noman.al_quran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SurahTranslationOptions extends AppCompatActivity {

    Button urdu_translation_1_btn;
    Button urdu_translation_2_btn;
    Button english_translation_1_btn;
    Button english_translation_2_btn;
    Button translation_none_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_translation_options);

        Intent intent = getIntent();
        int SurahID = intent.getIntExtra("SurahID", -1);
        Toast.makeText(this, "id: " + SurahID, Toast.LENGTH_SHORT).show();


        Intent newIntent =  new Intent(SurahTranslationOptions.this, ReadSurah.class);
        newIntent.putExtra("SurahID", SurahID);

        urdu_translation_1_btn = findViewById(R.id.urdu_translation_1);
        urdu_translation_2_btn = findViewById(R.id.urdu_translation_2);
        english_translation_1_btn = findViewById(R.id.english_translation_1);
        english_translation_2_btn = findViewById(R.id.english_translation_2);
        translation_none_btn = findViewById(R.id.translation_none);

        urdu_translation_1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newIntent.putExtra("Translation", "urdu_translation_1");
                startActivity(newIntent);
            }
        });
        urdu_translation_2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newIntent.putExtra("Translation", "urdu_translation_2");
                startActivity(newIntent);
            }
        });
        english_translation_1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newIntent.putExtra("Translation", "english_translation_1");
                startActivity(newIntent);
            }
        });
        english_translation_2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newIntent.putExtra("Translation", "english_translation_2");
                startActivity(newIntent);
            }
        });

        translation_none_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newIntent.putExtra("Translation", "translation_none");
                startActivity(newIntent);
            }
        });

    }
}