package com.bbcnewschallenge.core.domain.analytics

import com.bbcnewschallenge.core.domain.interfaces.AnalyticEvent
import com.bbcnewschallenge.core.domain.interfaces.AnalyticScreen

open class ClickAnalyticEvent(
    clickEvent: String,
    analyticScreen: AnalyticScreen
) : AnalyticEvent, AnalyticScreen by analyticScreen {
    final override val tag = "click"
    final override val params = mapOf(
        "clicked" to clickEvent
    )
}