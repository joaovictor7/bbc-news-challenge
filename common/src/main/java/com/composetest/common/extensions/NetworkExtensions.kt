package com.composetest.common.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

val Context.internetIsConnected: Boolean get() {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
    return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
}