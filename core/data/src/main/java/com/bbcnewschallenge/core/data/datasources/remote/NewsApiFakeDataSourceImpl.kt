package com.bbcnewschallenge.core.data.datasources.remote

import com.bbcnewschallenge.core.data.utils.RemoteCallUtils

internal class NewsApiFakeDataSourceImpl(
    private val requestUtils: RemoteCallUtils
) : NewsApiDataSource {

    override suspend fun getTopHeadlinesNews() = requestUtils.executeRemoteCall {
        TODO()
    }
}