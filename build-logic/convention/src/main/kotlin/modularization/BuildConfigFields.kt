package modularization

import com.android.build.api.dsl.ApplicationBuildType
import com.android.build.api.dsl.ApplicationDefaultConfig
import com.android.build.api.dsl.ApplicationProductFlavor
import enums.BuildType
import enums.File
import enums.Flavor
import enums.FlavorDimension
import extensions.loadPropertiesFile
import org.gradle.api.Project

internal fun ApplicationDefaultConfig.setDefaultBuildConfigFields(project: Project) =
    with(project) {
        val properties = loadPropertiesFile(File.API_KEYS)
        buildConfigField("String", "NEWS_API_API_HOST", "\"newsapi.org/v2/\"")
        buildConfigField("String", "NEWS_API_API_KEY", properties.getProperty("NEWS_API"))
    }

internal fun ApplicationBuildType.setBuildConfigFields(
    project: Project,
    buildType: BuildType
) = with(project) {
    when (buildType) {
        BuildType.RELEASE -> {}
        BuildType.DEBUG -> {}
    }
}

internal fun ApplicationProductFlavor.setBuildConfigFields(
    project: Project,
    dimension: FlavorDimension,
    flavor: Flavor
) = with(project) {
    when (flavor) {
        Flavor.PRODUCTION -> {}
        Flavor.DEVELOP -> {}
        Flavor.STAGING -> {}
    }
}