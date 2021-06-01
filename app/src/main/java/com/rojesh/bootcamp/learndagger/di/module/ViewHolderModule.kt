package com.rojesh.bootcamp.learndagger.di.module

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModelProviders
import com.rojesh.bootcamp.learndagger.data.local.DatabaseService
import com.rojesh.bootcamp.learndagger.data.remote.NetworkService
import com.rojesh.bootcamp.learndagger.di.ActivityContext
import com.rojesh.bootcamp.learndagger.di.ViewHolderScope
import com.rojesh.bootcamp.learndagger.ui.base.BaseFragment
import com.rojesh.bootcamp.learndagger.ui.base.BaseItemViewHolder
import com.rojesh.bootcamp.learndagger.ui.home.HomeViewModel
import com.rojesh.bootcamp.learndagger.ui.main.MainViewModel
import com.rojesh.bootcamp.learndagger.utils.NetworkHelper
import com.rojesh.bootcamp.learndagger.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*,*>) {

    @Provides
    @ViewHolderScope
    fun provideLifeCycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)



}
