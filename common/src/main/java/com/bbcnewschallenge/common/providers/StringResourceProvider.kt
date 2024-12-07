package com.bbcnewschallenge.common.providers

import androidx.annotation.StringRes

interface StringResourceProvider {
    fun getString(@StringRes stringId: Int, vararg args: Any): String
}