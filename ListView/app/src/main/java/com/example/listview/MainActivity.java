package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String [] items = {"Pen", "Book", "Chair", "Mouse", "Carpet", "Laptop",
        "Window","Charger", "Spray"
        };
        ListView listView = findViewById(R.id.list);
        ArrayAdapter adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = "Clicked " + items[i];
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
             }
        });
    }
}