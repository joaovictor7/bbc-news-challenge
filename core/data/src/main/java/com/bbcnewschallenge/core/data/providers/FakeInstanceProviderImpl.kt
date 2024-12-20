package com.bbcnewschallenge.core.data.providers

import com.bbcnewschallenge.common.enums.FlavorDimension
import com.bbcnewschallenge.common.providers.BuildConfigProvider
import javax.inject.Inject

internal class FakeInstanceProviderImpl @Inject constructor(
    private val buildConfigProvider: BuildConfigProvider
) : FakeInstanceProvider {

    override fun <Instance> getInstance(
        instance: Instance,
        fakeInstance: Instance
    ) = if (buildConfigProvider.get.flavorDimension == FlavorDimension.DEVELOP) {
        fakeInstance
    } else {
        instance
    }
}