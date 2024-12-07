package com.bbcnewschallenge.common.extensions

val String.digits get() = filter { it.isDigit() }

val String?.toIntOrZero get() = this?.toIntOrNull() ?: 0