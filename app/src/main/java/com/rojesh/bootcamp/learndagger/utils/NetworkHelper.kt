package com.rojesh.bootcamp.learndagger.utils

import android.content.Context

import com.rojesh.bootcamp.learndagger.di.ApplicationContext

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHelper @Inject constructor(
        // Should be Application Context
        @ApplicationContext private val context: Context) {

    // will check for network connectivity
    val isNetworkConnected =  false
}
