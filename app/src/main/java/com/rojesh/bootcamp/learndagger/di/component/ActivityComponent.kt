package com.rojesh.bootcamp.learndagger.di.component

import com.rojesh.bootcamp.learndagger.di.module.ActivityModule
import com.rojesh.bootcamp.learndagger.di.ActivityScope
import com.rojesh.bootcamp.learndagger.ui.main.MainActivity

import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}
