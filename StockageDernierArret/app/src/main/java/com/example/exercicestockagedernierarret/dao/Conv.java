package com.example.exercicestockagedernierarret.dao;

import java.util.Date;

import androidx.room.TypeConverter;

public class Conv {

    @TypeConverter
    public Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public Long dateToTimestamp(Date date) {
        if (date == null) {
            return null;
        } else {
            return date.getTime();
        }
    }
}