package com.rojesh.bootcamp.learndagger.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rojesh.bootcamp.learndagger.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable


abstract class BaseViewModel(
        protected val compositeDisposable: CompositeDisposable,
        protected val networkHelper: NetworkHelper
) : ViewModel() {

    val messageStringId = MutableLiveData<Int>()
    val messageString = MutableLiveData<String>()

    protected fun checkInternetConnection(): Boolean = networkHelper.isNetworkConnected()

    protected fun handleNetworkError(err:Throwable){
        //Handle error
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    abstract fun onCreate()




}