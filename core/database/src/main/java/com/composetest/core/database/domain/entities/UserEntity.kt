package com.composetest.core.database.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class UserEntity(
    @PrimaryKey @ColumnInfo(name = "userId") val id: String,
    val email: String,
    val name: String?
)
