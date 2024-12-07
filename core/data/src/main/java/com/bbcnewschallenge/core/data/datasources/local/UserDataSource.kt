package com.bbcnewschallenge.core.data.datasources.local

import com.bbcnewschallenge.core.database.entities.UserEntity

internal interface UserDataSource {
    suspend fun upsert(user: UserEntity)
    suspend fun getCurrentUser(): UserEntity?
}