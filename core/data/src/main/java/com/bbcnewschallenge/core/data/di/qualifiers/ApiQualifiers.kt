package com.bbcnewschallenge.core.data.di.qualifiers

import com.bbcnewschallenge.core.data.enums.NetworkApi
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class ApiQualifier(val networkApi: NetworkApi)