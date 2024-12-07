package com.bbcnewschallenge.core.domain.analytics

import com.bbcnewschallenge.core.domain.interfaces.AnalyticEvent
import com.bbcnewschallenge.core.domain.interfaces.AnalyticScreen

class OpenScreenAnalyticEvent(
    analyticScreen: AnalyticScreen
) : AnalyticEvent, AnalyticScreen by analyticScreen {
    override val tag = "open_screen"
    override val screen = analyticScreen.screen
    override val params = emptyMap<String, Any>()
}