package com.yulia.catatankeuangan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yulia.catatankeuangan.database.AppDatabase;
import com.yulia.catatankeuangan.database.entitas.User;

public class TambahActivity extends AppCompatActivity {
    private EditText editTanggal, editPengeluaran, editTotal;
    private Button btnSave;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        editTanggal = findViewById(R.id.tanggal);
        editPengeluaran = findViewById(R.id.pengeluaran);
        editTotal = findViewById(R.id.total);
        btnSave = findViewById(R.id.btn_save);

        database = AppDatabase.getInstance(getApplicationContext());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                database.UserDao().insertAll(editTanggal.getText().toString(), editPengeluaran.getText().toString(), editTotal.getText().toString());
                finish();
            }
        });
    }
}