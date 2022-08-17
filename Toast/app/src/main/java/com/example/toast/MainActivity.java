package com.example.toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String Colors[] = {"Red", "Green", "Blue"};
    ArrayList<Integer> items = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button show = findViewById(R.id.show);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Colors[] = {"Red", "Green", "Blue"};
                ArrayList<Integer> items = new ArrayList();
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Set Options")
                        .setMultiChoiceItems(Colors, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                if(b)
                                {
                                    items.add(i);
                                }
                                else if(items.contains(i))
                                {
                                    items.remove(Integer.valueOf(i));
                                }
                            }
                        })
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String msg = "";
                                for (int j = 0; j < items.size(); j++ )
                                {
                                    msg = msg + "\n" + (j+1) + ": " + Colors[items.get(j)];
                                }
                                Toast.makeText(getApplicationContext(), "Total " + items.size() + " Items Selected.\n" + msg,
                                        Toast.LENGTH_SHORT).show();                    }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .create();
                dialog.show();
            }
        });


    }
}