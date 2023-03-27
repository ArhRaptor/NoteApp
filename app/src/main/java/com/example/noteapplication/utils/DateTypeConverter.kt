package com.example.noteapplication.utils

import androidx.room.TypeConverter
import java.util.Date


class DateTypeConverter {

    @TypeConverter
    fun dateToLong(date: Date): Long = date.time

    @TypeConverter
    fun longToDate(long: Long): Date = Date(long)
}