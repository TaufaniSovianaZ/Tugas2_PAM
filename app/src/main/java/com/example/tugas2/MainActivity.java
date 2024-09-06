package com.example.tugas2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    RadioButton radTambah, radKurang, radKali, radBagi;
    Button hitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.angka1);
        num2 = findViewById(R.id.angka2);
        radTambah = findViewById(R.id.tambah);
        radKurang = findViewById(R.id.kurang);
        radKali = findViewById(R.id.kali);
        radBagi = findViewById(R.id.bagi);
        hitung = findViewById(R.id.hitung);

        hitung.setOnClickListener(view -> {
            String ang1 = num1.getText().toString();
            String ang2 = num2.getText().toString();

            if (ang1.isEmpty() || ang2.isEmpty()) {
                Toast.makeText(this, "Silahkan diisi terlebih dahulu!", Toast.LENGTH_SHORT).show();
                return;
            }

            double a1 = Double.parseDouble(ang1);
            double a2 = Double.parseDouble(ang2);
            double has = 0;
            String hasilFinal = "";

            if (radTambah.isChecked()) {
                has = a1 + a2;
                hasilFinal = String.valueOf((int) has);
            } else if (radKurang.isChecked()) {
                has = a1 - a2;
                hasilFinal = String.valueOf((int) has);
            } else if (radKali.isChecked()) {
                has = a1 * a2;
                hasilFinal = String.valueOf((int) has);
            } else if (radBagi.isChecked()) {
                if (a2 != 0) {
                    has = a1 / a2;
                    hasilFinal = String.valueOf(has);
                } else {
                    Toast.makeText(this, "Tidak bisa membagi dengan nol!", Toast.LENGTH_SHORT).show();
                    return;
                }
            } else {
                Toast.makeText(this, "Silahkan pilih operasi!", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(MainActivity.this, Activity_2.class);
            intent.putExtra("hasil", hasilFinal);
            startActivity(intent);
        });
    }
}