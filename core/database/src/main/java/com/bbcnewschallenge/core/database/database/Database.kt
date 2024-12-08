package com.bbcnewschallenge.core.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bbcnewschallenge.core.database.converters.LocalDateTimeConverter

private const val DATABASE_VERSION = 1

//@Database(
//    version = DATABASE_VERSION,
//    exportSchema = false,
//    entities = []
//)
//@TypeConverters(LocalDateTimeConverter::class)
//internal abstract class Database : RoomDatabase() {
//}