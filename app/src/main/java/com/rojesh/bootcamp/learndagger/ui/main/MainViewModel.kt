package com.rojesh.bootcamp.learndagger.ui.main

import androidx.lifecycle.MutableLiveData
import com.rojesh.bootcamp.learndagger.data.local.DatabaseService
import com.rojesh.bootcamp.learndagger.data.remote.NetworkService
import com.rojesh.bootcamp.learndagger.di.ActivityScope
import com.rojesh.bootcamp.learndagger.ui.base.BaseViewModel
import com.rojesh.bootcamp.learndagger.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

import javax.inject.Inject


class MainViewModel(composeDisposable: CompositeDisposable,
                    networkHelper: NetworkHelper,
                    private val databaseService: DatabaseService,
                    private val networkService: NetworkService) : BaseViewModel(
        composeDisposable,
        networkHelper) {
    val data = MutableLiveData<String>()

    override fun onCreate() {
        data.postValue("Main View model")
        if(!checkInternetConnection()) messageString.postValue("No Internet Connection ")
    }
}
