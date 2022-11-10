package com.example.exercicestockagedernierarret.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.exercicestockagedernierarret.model.Hour;


@Database(entities = {Hour.class},
        version = 1)
@TypeConverters({Conv.class})
    public abstract class BD extends RoomDatabase{
        public abstract DemoDAO dao();
}