package com.bbcnewschallenge.core.domain.repositories

import android.os.Bundle

interface AnalyticsRepository {
    fun logEvent(tag: String, bundle: Bundle)
    fun logNonFatalError(tag: String, throwable: Throwable, bundle: Bundle)
}