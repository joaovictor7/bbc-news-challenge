package com.bbcnewschallenge.core.data.datasources.local

import com.bbcnewschallenge.core.database.entities.SessionEntity
import com.bbcnewschallenge.core.database.entities.partialupdate.FinishedSessionEntityUpdate

internal interface SessionDataSource {
    suspend fun insert(entity: SessionEntity)

    suspend fun update(entity: FinishedSessionEntityUpdate)

    suspend fun getCurrentSession(): SessionEntity?
}