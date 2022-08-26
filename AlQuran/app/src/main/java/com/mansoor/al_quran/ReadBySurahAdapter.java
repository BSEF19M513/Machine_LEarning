package com.noman.al_quran;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ReadBySurahAdapter extends BaseAdapter {
    Context ReadByParaContext;
    Context context;
    DatabaseHelper databaseHelper;
    LayoutInflater inflater;
    ArrayList<SurahRecord> surahRecords;

    public ReadBySurahAdapter(Context applicationContext, Context ReadByParaContext, ArrayList<SurahRecord> surahRecords) {
        this.context = applicationContext;
        databaseHelper = new DatabaseHelper(ReadByParaContext);
        inflater = (LayoutInflater.from(applicationContext));
        this.ReadByParaContext = ReadByParaContext;
        this.surahRecords = surahRecords;
    }

    @Override
    public int getCount() {
        return surahRecords.size();
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
        view = inflater.inflate(R.layout.surah_title_listview, null);

        TextView title_urdu = view.findViewById(R.id.surah_title_urdu);
        TextView title_english = view.findViewById(R.id.surah_title_english);
        title_urdu.setText(surahRecords.get(i).getSurahNameU());
        title_english.setText(surahRecords.get(i).getSurahID() + ".  " + surahRecords.get(i).getSurahNameE());

        return view;
    }

}
