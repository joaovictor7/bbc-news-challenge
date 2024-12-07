package com.bbcnewschallenge.core.designsystem.params.switches

import androidx.annotation.DrawableRes
import com.bbcnewschallenge.core.designsystem.R

enum class SwitchType(
    @DrawableRes internal val checkedThumb: Int,
    @DrawableRes internal val uncheckedThumb: Int
) {
    CHECK(R.drawable.ic_check, R.drawable.ic_close)
}