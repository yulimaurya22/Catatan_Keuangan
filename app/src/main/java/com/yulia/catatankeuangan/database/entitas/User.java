package com.yulia.catatankeuangan.database.entitas;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "tanggal")
    public String tanggal;
    @ColumnInfo(name = "pengeluaran")
    public String pengeluaran;
    @ColumnInfo(name = "total")
    public String total;

}
