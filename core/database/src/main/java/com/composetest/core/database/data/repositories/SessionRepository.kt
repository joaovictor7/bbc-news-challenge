package com.composetest.core.database.data.repositories

import com.composetest.core.database.entities.SessionEntity
import com.composetest.core.database.entities.partialupdate.FinishedSessionEntityUpdate

interface SessionRepository {
    suspend fun insert(entity: SessionEntity)
    suspend fun update(entity: FinishedSessionEntityUpdate)
    suspend fun <T> getCurrentSession(mapper: (SessionEntity?) -> T): T
}