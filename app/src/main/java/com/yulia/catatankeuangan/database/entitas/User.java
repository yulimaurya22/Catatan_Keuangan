package com.yulia.catatankeuangan.database.entitas;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    public int uid;

    public String tanggal;

    public String pengeluaran;

    public String total;

}
