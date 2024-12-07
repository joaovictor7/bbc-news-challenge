package com.bbcnewschallenge.core.domain.usecases

import android.os.Bundle
import androidx.core.os.bundleOf
import com.bbcnewschallenge.common.providers.BuildConfigProvider
import com.bbcnewschallenge.core.domain.analytics.ErrorAnalyticEvent
import com.bbcnewschallenge.core.domain.interfaces.AnalyticEvent
import com.bbcnewschallenge.core.domain.repositories.AnalyticsRepository
import java.time.LocalDateTime
import javax.inject.Inject

class SendAnalyticsUseCase @Inject constructor(
    private val analyticsRepository: AnalyticsRepository,
    private val buildConfigProvider: BuildConfigProvider
) {

    suspend operator fun invoke(event: AnalyticEvent) {
        val bundle = createBundle(event)
        analyticsRepository.logEvent(event.tag, bundle)
    }

    suspend operator fun invoke(event: ErrorAnalyticEvent) {
        val bundle = createBundle(event)
        analyticsRepository.logNonFatalError(event.tag, event.throwable, bundle)
    }

    private fun createBundle(event: AnalyticEvent): Bundle {
        return bundleOf(
            DATE_TIME to LocalDateTime.now().toString(),
            APP_VERSION to buildConfigProvider.get.versionName,
            ANDROID_SDK_VERSION to buildConfigProvider.get.androidSdkVersion.toString(),
            *event.params.map { it.key to it.value.toString() }.toTypedArray()
        ).apply {
            event.screen?.let { putString(SCREEN, it) }
        }
    }

    private companion object {
        const val DATE_TIME = "date_time"
        const val APP_VERSION = "app_version"
        const val ANDROID_SDK_VERSION = "android_sdk_version"
        const val SCREEN = "screen"
    }
}