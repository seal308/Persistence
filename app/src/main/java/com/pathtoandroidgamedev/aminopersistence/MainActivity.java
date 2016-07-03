package com.pathtoandroidgamedev.aminopersistence;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String dataName = "dataStore";
    String defaultStringAmino = "Hi Amino";
    String stringNameAmino = "amino";
    String defaultStringYou = "Nice to meet you";
    String stringNameYou;
    String currentStringO;
    String currentStringU;
    Button aminoButton;
    Button youButton;
    Button buttonReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences(dataName, MODE_PRIVATE);
        editor = prefs.edit();

        currentStringO = prefs.getString(stringNameAmino, defaultStringAmino);
        currentStringU = prefs.getString(stringNameYou, defaultStringYou);

        aminoButton = (Button)findViewById(R.id.buttonO);
        youButton = (Button)findViewById(R.id.buttonU);
        buttonReset = (Button)findViewById(R.id.buttonReset);
        aminoButton.setOnClickListener(this);
        youButton.setOnClickListener(this);
        aminoButton.setText(currentStringO);
        youButton.setText(currentStringU);
        buttonReset.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
        case R.id.buttonO:
            currentStringO+= 'o';

            // Try commenting out these editor lines, run app, kill app and run it again and see what happens!
            //editor.putString(stringNameAmino, currentStringO);
            //editor.commit();
            aminoButton.setText(currentStringO);
            break;

        case R.id.buttonU:
            //Log.i("info", "in buttonU");
            currentStringU+= 'u';
            editor.putString(stringNameYou, currentStringU);
            editor.commit();
            youButton.setText(currentStringU);
            break;

            case R.id.buttonReset:
                //Log.i("info", "in buttonReset");
                currentStringO=defaultStringAmino;
                currentStringU=defaultStringYou;
                editor.putString(stringNameAmino, currentStringO);
                editor.putString(stringNameYou, currentStringU);
                editor.commit();
                aminoButton.setText(currentStringO);
                youButton.setText(currentStringU);
                break;
        }


    }
}
