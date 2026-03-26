package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private EditText etNom, etApe, etN1, etN2;
    private Button btnSig, btnCerrar;
    private int num1, num2;

    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    num1 = result.getData().getIntExtra("n1", 0);
                    num2 = result.getData().getIntExtra("n2", 0);
                    etN1.setText(String.valueOf(num1));
                    etN2.setText(String.valueOf(num2));
                    btnCerrar.setEnabled(true); // Se habilita al volver de la 3
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        etNom = findViewById(R.id.etNombre2);
        etApe = findViewById(R.id.etApellido2);
        etN1 = findViewById(R.id.etNum1_2);
        etN2 = findViewById(R.id.etNum2_2);
        btnSig = findViewById(R.id.btnSiguiente2);
        btnCerrar = findViewById(R.id.btnCerrar2);

        btnSig.setOnClickListener(v -> {
            launcher.launch(new Intent(this, ThirdActivity.class));

        });

        btnCerrar.setOnClickListener(v -> {
            Intent res = new Intent();
            res.putExtra("nombre", etNom.getText().toString());
            res.putExtra("apellido", etApe.getText().toString());
            res.putExtra("n1", num1);
            res.putExtra("n2", num2);
            setResult(RESULT_OK, res);
            finish();
        });
    }
}