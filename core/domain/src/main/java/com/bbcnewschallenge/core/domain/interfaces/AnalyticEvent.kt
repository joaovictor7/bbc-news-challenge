package com.bbcnewschallenge.core.domain.interfaces

interface AnalyticEvent : AnalyticScreen {
    val tag: String
    val params: Map<String, *>
}