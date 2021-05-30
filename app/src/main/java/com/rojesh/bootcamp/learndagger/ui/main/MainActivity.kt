package com.rojesh.bootcamp.learndagger.ui.main

import android.os.Bundle
import androidx.lifecycle.Observer
import com.rojesh.bootcamp.learndagger.R
import com.rojesh.bootcamp.learndagger.di.component.ActivityComponent
import com.rojesh.bootcamp.learndagger.ui.base.BaseActivity
import com.rojesh.bootcamp.learndagger.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>() {

    override fun provideLayoutId() = R.layout.activity_main

    override fun setUpView(savedInstanceState: Bundle?) =
            addHomeFragment()


    override fun setUpObservers() {
        super.setUpObservers()
        viewModel.data.observe(this, Observer {
            tv_message.text = it
        })
    }

    override fun injectDependencies(activityComponent: ActivityComponent) =
            activityComponent.inject(this)

    private fun addHomeFragment() {
        if (supportFragmentManager.findFragmentByTag(HomeFragment.TAG) == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container_fragment, HomeFragment.newInstance(), HomeFragment.TAG)
                    .commit()
        }
    }


}
