package com.bbcnewschallenge.core.security.providers

import androidx.sqlite.db.SupportSQLiteOpenHelper

interface SqliteCipherProvider {
    fun getFactory(key: String): SupportSQLiteOpenHelper.Factory
}