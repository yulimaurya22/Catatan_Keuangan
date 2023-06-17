package com.yulia.catatankeuangan.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.yulia.catatankeuangan.database.entitas.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("INSERT INTO user(tanggal,pengeluaran,total) VALUES(:tanggal,:pengeluaran,:total)")
    void insertAll(String tanggal, String pengeluaran, String total);

    @Query("UPDATE user SET tanggal=:tanggal, pengeluaran=:pengeluaran, total=:total WHERE uid=:uid")
    void update(int uid, String tanggal, String pengeluaran, String total);

    @Query("SELECT * FROM user WHERE uid=:uid")
    User get(int uid);

    @Delete
    void delete(User user);
}
