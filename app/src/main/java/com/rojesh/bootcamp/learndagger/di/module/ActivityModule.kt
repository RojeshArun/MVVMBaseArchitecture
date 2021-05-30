package com.rojesh.bootcamp.learndagger.di.module

import android.app.Activity
import android.content.Context

import com.rojesh.bootcamp.learndagger.di.ActivityContext

import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = activity
}
