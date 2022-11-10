package com.example.exercicestockagedernierarret.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Hour {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo
    public Date date;
}
