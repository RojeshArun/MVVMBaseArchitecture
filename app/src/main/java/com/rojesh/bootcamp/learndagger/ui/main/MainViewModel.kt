package com.rojesh.bootcamp.learndagger.ui.main

import com.rojesh.bootcamp.learndagger.data.local.DatabaseService
import com.rojesh.bootcamp.learndagger.data.remote.NetworkService
import com.rojesh.bootcamp.learndagger.di.ActivityScope

import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(
        private val databaseService: DatabaseService,
        private val networkService: NetworkService) {

    val someData: String
        get() = databaseService.dummyData + " : " + networkService.dummyData
}
