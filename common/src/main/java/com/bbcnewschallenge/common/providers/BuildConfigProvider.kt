package com.bbcnewschallenge.common.providers

import com.bbcnewschallenge.common.models.BuildConfigModel

interface BuildConfigProvider {
    val get: BuildConfigModel
}