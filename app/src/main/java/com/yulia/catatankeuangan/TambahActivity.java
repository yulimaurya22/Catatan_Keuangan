package com.yulia.catatankeuangan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    private int uid = 0;
    private boolean isEdit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        getSupportActionBar().setTitle("Detail Pengeluaran");

        editTanggal = findViewById(R.id.tanggal);
        editPengeluaran = findViewById(R.id.pengeluaran);
        editTotal = findViewById(R.id.total);
        btnSave = findViewById(R.id.btn_save);

        database = AppDatabase.getInstance(getApplicationContext());

        Intent intent = getIntent();
        uid = intent.getIntExtra("uid", 0);
        if (uid>0){
            isEdit = true;
            User user = database.UserDao().get(uid);
            editTanggal.setText(user.tanggal);
            editPengeluaran.setText(user.pengeluaran);
            editTotal.setText(user.total);

        }else {
            isEdit = false;
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEdit){
                    database.UserDao().update(uid,editTanggal.getText().toString(), editPengeluaran.getText().toString(), editTotal.getText().toString() );
                }else{
                    database.UserDao().insertAll(editTanggal.getText().toString(), editPengeluaran.getText().toString(), editTotal.getText().toString());
                }
                finish();
            }
        });
    }
}