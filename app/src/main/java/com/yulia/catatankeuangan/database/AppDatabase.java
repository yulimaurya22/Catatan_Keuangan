package com.yulia.catatankeuangan.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.yulia.catatankeuangan.database.entitas.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
}
