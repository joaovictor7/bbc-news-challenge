package com.bbcnewschallenge.core.router.di.qualifiers

import com.bbcnewschallenge.core.router.enums.NavGraph
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NavGraphQualifier(val navGraph: NavGraph)