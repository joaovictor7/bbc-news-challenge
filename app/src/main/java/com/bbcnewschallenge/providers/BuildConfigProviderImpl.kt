package com.bbcnewschallenge.providers

import android.os.Build
import com.bbcnewschallenge.BuildConfig
import com.bbcnewschallenge.common.enums.BuildType.Companion.getBuildType
import com.bbcnewschallenge.common.enums.Flavor.Companion.getFlavor
import com.bbcnewschallenge.common.enums.FlavorDimension.Companion.getDimensionFlavor
import com.bbcnewschallenge.common.models.BuildConfigFieldsModel
import com.bbcnewschallenge.common.models.BuildConfigModel
import com.bbcnewschallenge.common.providers.BuildConfigProvider
import javax.inject.Inject

internal class BuildConfigProviderImpl @Inject constructor() : BuildConfigProvider {
    override val get = BuildConfigModel(
        applicationId = BuildConfig.APPLICATION_ID,
        versionName = BuildConfig.VERSION_NAME,
        versionCode = BuildConfig.VERSION_CODE,
        buildType = BuildConfig.BUILD_TYPE.getBuildType(),
        flavorDimension = BuildConfig.FLAVOR_environment.getDimensionFlavor(),
        flavor = BuildConfig.FLAVOR_source.getFlavor(),
        androidSdkVersion = Build.VERSION.SDK_INT,
        buildConfigFieldsModel = BuildConfigFieldsModel(
            newsApiHost = BuildConfig.NEWS_API_API_HOST,
            newsApiKey = BuildConfig.NEWS_API_API_KEY
        )
    )
}