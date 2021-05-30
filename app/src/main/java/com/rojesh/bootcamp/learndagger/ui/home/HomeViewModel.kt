package com.rojesh.bootcamp.learndagger.ui.home

import com.rojesh.bootcamp.learndagger.data.local.DatabaseService
import com.rojesh.bootcamp.learndagger.data.remote.NetworkService
import com.rojesh.bootcamp.learndagger.di.FragmentScope
import com.rojesh.bootcamp.learndagger.utils.NetworkHelper

import javax.inject.Inject

@FragmentScope
class HomeViewModel @Inject constructor(
        private val databaseService: DatabaseService,
        private val networkService: NetworkService,
        private val networkHelper: NetworkHelper) {

    val someData: String
        get() = (databaseService.dummyData
                + " : " + networkService.dummyData
                + " : " + networkHelper.isNetworkConnected())
}
