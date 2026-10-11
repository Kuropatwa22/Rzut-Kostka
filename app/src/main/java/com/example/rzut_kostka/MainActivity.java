package com.example.rzut_kostka;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    TextView tvCount;

    int liczbaRzutow = 0;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
        tvCount = findViewById(R.id.tvCount);
    }

    public void rzucKostke(View view) {
        int wynik = random.nextInt(6) + 1;

        liczbaRzutow++;

        tvResult.setText(String.valueOf(wynik));
        tvCount.setText(getString(R.string.count, liczbaRzutow));
    }
}

