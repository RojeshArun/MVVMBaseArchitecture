package com.rojesh.bootcamp.learndagger.di.component

import com.rojesh.bootcamp.learndagger.di.module.FragmentModule
import com.rojesh.bootcamp.learndagger.di.FragmentScope
import com.rojesh.bootcamp.learndagger.ui.home.HomeFragment

import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(fragment: HomeFragment)
}
