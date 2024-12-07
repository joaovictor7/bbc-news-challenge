package com.bbcnewschallenge.core.data.repositories

import com.bbcnewschallenge.core.data.constants.PreferencesDataKeys.sqliteSecretKey
import com.bbcnewschallenge.core.data.datasources.local.PreferenceDataSource
import com.bbcnewschallenge.core.domain.repositories.SecretKeyRepository
import javax.inject.Inject

internal class SecretKeyRepositoryImpl @Inject constructor(
    private val preferenceDataSource: PreferenceDataSource
) : SecretKeyRepository {

    override suspend fun getSqliteSecretKey() = preferenceDataSource.getData { preferences ->
        preferences[sqliteSecretKey]
    }

    override suspend fun setSqliteSecretKey(secretKey: String) =
        preferenceDataSource.setData(sqliteSecretKey, secretKey)
}