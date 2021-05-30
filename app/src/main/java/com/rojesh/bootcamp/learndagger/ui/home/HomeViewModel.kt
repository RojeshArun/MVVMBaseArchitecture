package com.rojesh.bootcamp.learndagger.ui.home

import androidx.lifecycle.MutableLiveData
import com.rojesh.bootcamp.learndagger.data.local.DatabaseService
import com.rojesh.bootcamp.learndagger.data.remote.NetworkService
import com.rojesh.bootcamp.learndagger.di.FragmentScope
import com.rojesh.bootcamp.learndagger.ui.base.BaseViewModel
import com.rojesh.bootcamp.learndagger.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

import javax.inject.Inject


class HomeViewModel(
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        private val databaseService: DatabaseService,
        private val networkService: NetworkService) :
        BaseViewModel(compositeDisposable, networkHelper) {

    val data = MutableLiveData<String>()

    override fun onCreate() {
        data.postValue("Home View Model")
    }


}
