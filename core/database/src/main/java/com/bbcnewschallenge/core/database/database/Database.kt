package com.bbcnewschallenge.core.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bbcnewschallenge.core.database.converters.LocalDateTimeConverter

internal const val DATABASE_NAME = "bbc_news_challenge_database"
private const val DATABASE_VERSION = 1

@Database(
    version = DATABASE_VERSION,
    exportSchema = false,
    entities = []
)
@TypeConverters(LocalDateTimeConverter::class)
internal abstract class AppDatabase : RoomDatabase() {
}