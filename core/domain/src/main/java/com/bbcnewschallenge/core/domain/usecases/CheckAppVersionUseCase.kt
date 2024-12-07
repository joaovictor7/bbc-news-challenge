package com.bbcnewschallenge.core.domain.usecases

import com.bbcnewschallenge.common.extensions.digits
import com.bbcnewschallenge.common.extensions.toIntOrZero
import com.bbcnewschallenge.common.providers.BuildConfigProvider
import javax.inject.Inject

class CheckAppVersionUseCase @Inject constructor(
    private val buildConfigProvider: BuildConfigProvider
) {

    operator fun invoke(versionToCompare: String) =
        versionToCompare.digits.toIntOrZero >= buildConfigProvider.get.fullyVersion.digits.toIntOrZero
}