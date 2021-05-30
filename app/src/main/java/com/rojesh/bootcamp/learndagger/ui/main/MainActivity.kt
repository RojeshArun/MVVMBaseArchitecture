package com.rojesh.bootcamp.learndagger.ui.main

import android.os.Bundle
import android.widget.TextView

import com.rojesh.bootcamp.learndagger.MyApplication
import com.rojesh.bootcamp.learndagger.R
import com.rojesh.bootcamp.learndagger.di.component.DaggerActivityComponent
import com.rojesh.bootcamp.learndagger.di.module.ActivityModule
import com.rojesh.bootcamp.learndagger.ui.home.HomeFragment

import javax.inject.Inject

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvData = findViewById<TextView>(R.id.tv_message)
        tvData.text = viewModel.someData

        addHomeFragment()
    }

    private fun addHomeFragment() {
        if (supportFragmentManager.findFragmentByTag(HomeFragment.TAG) == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container_fragment, HomeFragment.newInstance(), HomeFragment.TAG)
                    .commit()
        }
    }

    private fun getDependencies() {
        DaggerActivityComponent
                .builder()
                .applicationComponent((application as MyApplication).applicationComponent)
                .activityModule(ActivityModule(this))
                .build()
                .inject(this)
    }
}
