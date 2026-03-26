package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        EditText etN1 = findViewById(R.id.etPrimerNumero3);
        EditText etN2 = findViewById(R.id.etSegundoNumero3);
        Button btnCerrar = findViewById(R.id.btnCerrar3);

        btnCerrar.setOnClickListener(v -> {
            int n1 = 0, n2 = 0;
            try {
                n1 = Integer.parseInt(etN1.getText().toString());
                n2 = Integer.parseInt(etN2.getText().toString());
            } catch (Exception ignored) {}

            Intent res = new Intent();
            res.putExtra("n1", n1);
            res.putExtra("n2", n2);
            setResult(RESULT_OK, res);
            finish();

        });
    }
}