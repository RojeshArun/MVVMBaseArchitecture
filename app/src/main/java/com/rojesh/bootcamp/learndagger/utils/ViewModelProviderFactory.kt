package com.rojesh.bootcamp.learndagger.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.KClass

class ViewModelProviderFactory<T : ViewModel>(
        private val kClass: KClass<T>,
        private val creator: () -> T
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(kClass.java)) return creator() as T
        throw IllegalAccessException("Unknown class name")
    }
}