package com.bbcnewschallenge.core.domain.usecases

import com.bbcnewschallenge.common.providers.BuildConfigProvider
import com.bbcnewschallenge.core.domain.repositories.SecretKeyRepository
import com.bbcnewschallenge.core.security.providers.CipherProvider
import com.bbcnewschallenge.core.security.utils.getAlphanumericRandomKey
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class GetSqliteSecretKeyUseCase @Inject constructor(
    private val cipherProvider: CipherProvider,
    private val buildConfigProvider: BuildConfigProvider,
    private val secretKeyRepository: SecretKeyRepository
) {
    suspend operator fun invoke() = if (buildConfigProvider.get.isRelease) {
        getOrCreateSecretKey()
    } else null

    private suspend fun getOrCreateSecretKey(): String {
        val encryptedSecretKey = secretKeyRepository.getSqliteSecretKey().firstOrNull()
        return if (encryptedSecretKey == null) getAlphanumericRandomKey(SECRET_KEY_SIZE).also {
            secretKeyRepository.setSqliteSecretKey(cipherProvider.encrypt(it))
        } else cipherProvider.decrypt(encryptedSecretKey)
    }

    private companion object {
        const val SECRET_KEY_SIZE = 300
    }
}