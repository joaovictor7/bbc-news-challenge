package com.bbcnewschallenge.core.designsystem.enums.textfields

import androidx.annotation.DrawableRes
import com.bbcnewschallenge.core.designsystem.R

enum class TextFieldIcons(@DrawableRes val iconId: Int) {
    CLEAR_TEXT(R.drawable.ic_cancel),
    ERROR(R.drawable.ic_error),
    SEARCH(R.drawable.ic_search)
}