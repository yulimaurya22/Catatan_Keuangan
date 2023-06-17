package com.yulia.catatankeuangan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;

import com.yulia.catatankeuangan.adapter.UserAdapter;
import com.yulia.catatankeuangan.database.AppDatabase;
import com.yulia.catatankeuangan.database.entitas.User;

import java.util.ArrayList;
import java.util.List;

public class catatan extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btnTambah;
    private AppDatabase database;
    private UserAdapter userAdapter;
    private List<User> list = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan);
        recyclerView = findViewById(R.id.recycler_view);
        btnTambah = findViewById(R.id.btn_tambah);

        database = AppDatabase.getInstance(getApplicationContext());
        list.clear();
        list.addAll(database.UserDao().getAll());
        userAdapter = new UserAdapter(getApplicationContext(), list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(userAdapter);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(catatan.this, TambahActivity.class));

            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        list.clear();
        list.addAll(database.UserDao().getAll());
        userAdapter.notifyDataSetChanged();
    }
}