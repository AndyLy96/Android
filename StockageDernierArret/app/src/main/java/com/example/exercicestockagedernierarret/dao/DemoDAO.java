package com.example.exercicestockagedernierarret.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.exercicestockagedernierarret.model.Hour;

import java.util.Date;
import java.util.List;

@Dao
public interface DemoDAO {

    @Insert
    long createHour(Hour hour);

    @Query("DELETE FROM Hour")
    public void nukeTable();

    @Query("SELECT * FROM HOUR")
    List<Hour> AllHours();

    @Query("SELECT date FROM HOUR")
    List<Date> toutesLesDates();
}
