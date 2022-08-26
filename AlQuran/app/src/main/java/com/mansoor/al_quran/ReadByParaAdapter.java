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

public class ReadByParaAdapter extends BaseAdapter {
    Context ReadByParaContext;
    Context context;
    DatabaseHelper databaseHelper;
    LayoutInflater inflater;
    ArrayList<String> ParaList;
    ArrayList<String> englishParahNames;
    ArrayList<String> urduParahNames;

    public ReadByParaAdapter(Context applicationContext, Context ReadByParaContext, ArrayList<String> ParaList, ArrayList<String> englishParahNames, ArrayList<String> urduParahNames) {
        this.context = applicationContext;
        databaseHelper = new DatabaseHelper(ReadByParaContext);
        inflater = (LayoutInflater.from(applicationContext));
        this.ReadByParaContext = ReadByParaContext;
        this.ParaList = ParaList;
        this.urduParahNames = urduParahNames;
        this.englishParahNames = englishParahNames;
    }

    @Override
    public int getCount() {
        return ParaList.size();
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
        view = inflater.inflate(R.layout.para_title_listview, null);

        TextView title_urdu = view.findViewById(R.id.para_title_urdu);
        TextView title_english = view.findViewById(R.id.para_title_english);
        title_urdu.setText(urduParahNames.get(i));
        title_english.setText(ParaList.get(i) + ".  " + englishParahNames.get(i));

        return view;
    }

}
