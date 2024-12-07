package com.bbcnewschallenge.core.data.datasources.local

import com.bbcnewschallenge.core.database.daos.SessionEntityDao
import com.bbcnewschallenge.core.database.entities.SessionEntity
import com.bbcnewschallenge.core.database.entities.partialupdate.FinishedSessionEntityUpdate
import javax.inject.Inject

internal class SessionDataSourceImpl @Inject constructor(
    private val sessionEntityDao: SessionEntityDao
) : SessionDataSource {

    override suspend fun insert(entity: SessionEntity) {
        sessionEntityDao.insert(entity)
    }

    override suspend fun update(entity: FinishedSessionEntityUpdate) {
        sessionEntityDao.update(entity)
    }

    override suspend fun getCurrentSession() = sessionEntityDao.getCurrentSession()
}