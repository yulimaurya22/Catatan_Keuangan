package com.yulia.catatankeuangan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //menambahkan tombol kembali

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

                // menambahkan Notifikasi
                Intent intent = new Intent(getApplicationContext(), Catatan.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0,
                        intent, PendingIntent.FLAG_ONE_SHOT);

                Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext(),"CH1")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                                .setContentText("Selamat, Data Anda Berhasil Disimpan")
                                        .setContentTitle("Notifikasi")
                                                .setAutoCancel(true)
                                                        .setSound(defaultSoundUri)
                                                                .setContentIntent(pendingIntent);
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                NotificationChannel channel = new NotificationChannel("CH1", "Notifikasi", NotificationManager.IMPORTANCE_DEFAULT);
                notificationManager.createNotificationChannel(channel);
                }

                notificationManager.notify(0, notificationBuilder.build());
                finish();
            }
        });
    }
}