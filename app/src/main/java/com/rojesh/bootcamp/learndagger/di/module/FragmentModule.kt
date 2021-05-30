package com.rojesh.bootcamp.learndagger.di.module

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.rojesh.bootcamp.learndagger.data.local.DatabaseService
import com.rojesh.bootcamp.learndagger.data.remote.NetworkService
import com.rojesh.bootcamp.learndagger.di.ActivityContext
import com.rojesh.bootcamp.learndagger.ui.base.BaseFragment
import com.rojesh.bootcamp.learndagger.ui.home.HomeViewModel
import com.rojesh.bootcamp.learndagger.ui.main.MainViewModel
import com.rojesh.bootcamp.learndagger.utils.NetworkHelper
import com.rojesh.bootcamp.learndagger.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = fragment.context!!


    @Provides
    fun provideHomeViewModel(
            compositeDisposable: CompositeDisposable,
            networkHelper: NetworkHelper,
            databaseService: DatabaseService,
            networkService: NetworkService
    ): HomeViewModel =
            ViewModelProviders.of(fragment, ViewModelProviderFactory(HomeViewModel::class) {
                HomeViewModel(compositeDisposable,
                        networkHelper,
                        databaseService,
                        networkService)
            }).get(HomeViewModel::class.java)
}
