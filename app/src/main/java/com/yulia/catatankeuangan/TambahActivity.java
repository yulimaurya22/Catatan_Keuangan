package com.yulia.catatankeuangan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TambahActivity extends AppCompatActivity {
    private EditText editTanggal, editPengeluaran, editTotal;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        editTanggal = findViewById(R.id.tanggal);
        editPengeluaran = findViewById(R.id.pengeluaran);
        editTotal = findViewById(R.id.total);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}