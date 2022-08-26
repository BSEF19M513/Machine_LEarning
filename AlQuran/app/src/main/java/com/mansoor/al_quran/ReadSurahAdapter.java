package com.noman.al_quran;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.Bidi;
import java.util.ArrayList;

public class ReadSurahAdapter extends BaseAdapter {
    Context ReadByParaContext;
    Context context;
    DatabaseHelper databaseHelper;
    LayoutInflater inflater;
    ArrayList<ParaRecord> AyatList;
    String translation;

    public ReadSurahAdapter(Context applicationContext, Context ReadByParaContext, ArrayList<ParaRecord> AyatList, String translation) {
        this.context = applicationContext;
        databaseHelper = new DatabaseHelper(ReadByParaContext);
        inflater = (LayoutInflater.from(applicationContext));
        this.ReadByParaContext = ReadByParaContext;
        this.AyatList = AyatList;
        this.translation = translation;
    }

    @Override
    public int getCount() {
        return AyatList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.surah_aya_listview, null);
        TextView aya = view.findViewById(R.id.surah_aya);
        aya.setText(AyatList.get(i).getArabicText());
        TextView translation_type = view.findViewById(R.id.surah_aya_translation);
        if(translation.equals("urdu_translation_1") ) {
            translation_type.setText(AyatList.get(i).getUrduTranslation1());
        } else if(translation.equals("urdu_translation_2")) {
            translation_type.setText(AyatList.get(i).getUrduTranslation2());
        } else if(translation.equals("english_translation_1")) {
            translation_type.setText(AyatList.get(i).getEnglishTranslation1());
            translation_type.setTextDirection(Bidi.DIRECTION_DEFAULT_RIGHT_TO_LEFT);
        } else if(translation.equals("english_translation_2")) {
            translation_type.setText(AyatList.get(i).getEnglishTranslation2());
            translation_type.setTextDirection(Bidi.DIRECTION_DEFAULT_RIGHT_TO_LEFT);
        } else {
            translation_type.setVisibility(View.GONE);
        }
        return view;
    }

}
