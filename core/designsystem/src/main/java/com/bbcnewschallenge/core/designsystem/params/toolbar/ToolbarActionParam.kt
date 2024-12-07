package com.bbcnewschallenge.core.designsystem.params.toolbar

import com.bbcnewschallenge.core.designsystem.enums.toolbar.ToolbarAction

data class ToolbarActionParam(
    val action: ToolbarAction,
    val onClickAction: () -> Unit
)