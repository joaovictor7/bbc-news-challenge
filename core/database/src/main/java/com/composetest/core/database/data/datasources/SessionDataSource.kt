package com.composetest.core.database.data.datasources

import com.composetest.core.database.entities.SessionEntity
import com.composetest.core.database.entities.partialupdate.FinishedSessionEntityUpdate

internal interface SessionDataSource {
    suspend fun insert(entity: SessionEntity)

    suspend fun update(entity: FinishedSessionEntityUpdate)

    suspend fun getCurrentSession(): SessionEntity?
}