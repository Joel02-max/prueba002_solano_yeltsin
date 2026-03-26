package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre, etApellido, etNum1, etNum2, etMulti, etPotencia, etFactorial;
    private Button btnSiguiente, btnResultados;
    private String nombre, apellido;
    private int n1, n2;

    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();
                    nombre = data.getStringExtra("nombre");
                    apellido = data.getStringExtra("apellido");
                    n1 = data.getIntExtra("n1", 0);
                    n2 = data.getIntExtra("n2", 0);
                    btnResultados.setEnabled(true);
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialización
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etNum1 = findViewById(R.id.etPrimerNumero);
        etNum2 = findViewById(R.id.etSegundoNumero);
        etMulti = findViewById(R.id.etMultiplicacion);
        etPotencia = findViewById(R.id.etPotenciacion);
        etFactorial = findViewById(R.id.etFactorial);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        btnResultados = findViewById(R.id.btnResultados);

        btnSiguiente.setOnClickListener(v -> {
            launcher.launch(new Intent(this, SecondActivity.class));
        });

        btnResultados.setOnClickListener(v -> {
            etNombre.setText(nombre);
            etApellido.setText(apellido);
            etNum1.setText(String.valueOf(n1));
            etNum2.setText(String.valueOf(n2));


            etMulti.setText(String.valueOf(n1 * n2));

            double resPotencia = Math.pow(n1, n2);
            etPotencia.setText(String.valueOf((long) resPotencia));

            long fact = 1;
            for (int i = 1; i <= n1; i++) {
                fact *= i;
            }
            etFactorial.setText(String.valueOf(fact));
        });
    }
}