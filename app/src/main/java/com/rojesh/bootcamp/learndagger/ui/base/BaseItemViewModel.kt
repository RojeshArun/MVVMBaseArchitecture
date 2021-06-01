package com.rojesh.bootcamp.learndagger.ui.base

import androidx.lifecycle.MutableLiveData
import com.rojesh.bootcamp.learndagger.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

abstract class BaseItemViewModel<T : Any>(
        composeDisposable: CompositeDisposable,
        newtWorkHelper: NetworkHelper
):BaseViewModel(composeDisposable,newtWorkHelper) {

    val data = MutableLiveData<T>()

    fun onManualCleared() = onCleared()

    fun updateDate(data: T){
        this.data.postValue(data)
    }





}