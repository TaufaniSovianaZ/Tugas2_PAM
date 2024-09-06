package com.example.tugas2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);
        TextView hasilView = findViewById(R.id.tv_hasil);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String hasil = extras.getString("hasil");
            hasilView.setText(hasil);
        }
    }
}