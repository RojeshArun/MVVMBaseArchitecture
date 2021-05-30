package com.rojesh.bootcamp.learndagger.di.component

import android.content.Context
import com.rojesh.bootcamp.learndagger.MyApplication
import com.rojesh.bootcamp.learndagger.data.local.DatabaseService
import com.rojesh.bootcamp.learndagger.data.remote.NetworkService
import com.rojesh.bootcamp.learndagger.di.ApplicationContext
import com.rojesh.bootcamp.learndagger.di.module.ApplicationModule
import com.rojesh.bootcamp.learndagger.utils.NetworkHelper
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MyApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getDatabaseService(): DatabaseService

    fun getNetworkHelper(): NetworkHelper

    fun getCompositeDisposable(): CompositeDisposable
}
