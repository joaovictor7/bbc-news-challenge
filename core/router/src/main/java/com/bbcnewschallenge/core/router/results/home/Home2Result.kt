package com.bbcnewschallenge.core.router.results.home

import com.bbcnewschallenge.core.router.interfaces.ResultParam
import kotlinx.parcelize.Parcelize

@Parcelize
data class Home2Result(
    val e: String
) : ResultParam
