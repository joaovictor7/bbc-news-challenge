package com.bbcnewschallenge.core.designsystem.params.textfields

import com.bbcnewschallenge.core.designsystem.enums.textfields.TextFieldIcons

data class TextFieldTrailingIconParam(
    val iconType: TextFieldIcons,
    val onClick: (() -> Unit)? = null
)