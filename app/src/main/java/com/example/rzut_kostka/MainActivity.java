package com.example.rzut_kostka;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
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
        Button btnClear = findViewById(R.id.btnClear);
        Button btnReset = findViewById(R.id.btnReset);

        View.OnClickListener listener = v -> {
            if (v.getId() == R.id.btnClear) {
                if (liczbaRzutow == 0) {
                    Toast.makeText(this, R.string.error_no_rolls,
                            Toast.LENGTH_SHORT).show();
                } else {
                    tvResult.setText("");
                }
            } else {
                liczbaRzutow = 0;
                tvResult.setText(R.string.start_result);
                tvCount.setText(getString(R.string.count, liczbaRzutow));
            }
        };

        btnClear.setOnClickListener(listener);
        btnReset.setOnClickListener(listener);
    }

    public void rzucKostke(View view) {
        int wynik = random.nextInt(6) + 1;

        liczbaRzutow++;

        tvResult.setText(String.valueOf(wynik));
        tvCount.setText(getString(R.string.count, liczbaRzutow));
    }
}

