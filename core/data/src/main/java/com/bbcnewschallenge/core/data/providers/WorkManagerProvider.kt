package com.bbcnewschallenge.core.data.providers

import com.bbcnewschallenge.core.data.workmanagers.WorkManager

interface WorkManagerProvider {

    fun createPeriodicWork(workManager: WorkManager.PeriodicWorkManager)

    fun createOneTimeWork(workManager: WorkManager.OneTimeWorkManager)
}