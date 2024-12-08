package com.bbcnewschallenge.core.domain.enums

import com.bbcnewschallenge.core.domain.remoteconfigs.FeatureRemoteConfig

enum class Feature(internal val remoteConfig: FeatureRemoteConfig) {
    HOME(FeatureRemoteConfig.Home),
}