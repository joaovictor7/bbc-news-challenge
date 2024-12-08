package com.bbcnewschallenge.core.domain.remoteconfigs

import com.bbcnewschallenge.core.domain.interfaces.RemoteConfig

internal sealed interface FeatureRemoteConfig : RemoteConfig {
    data object Home : FeatureRemoteConfig {
        override val key = "feature_home"
    }
}