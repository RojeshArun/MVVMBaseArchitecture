package com.rojesh.bootcamp.learndagger.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.rojesh.bootcamp.learndagger.R
import com.rojesh.bootcamp.learndagger.di.component.FragmentComponent
import com.rojesh.bootcamp.learndagger.ui.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*

class HomeFragment : BaseFragment<HomeViewModel>() {

    companion object {

        val TAG = "HomeFragment"

        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun provideLayoutId() = R.layout.fragment_home


    override fun setUpObservers() {
        super.setUpObservers()
        viewModel.data.observe(this, Observer {
            tv_message.text = it
        })
    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) =
            fragmentComponent.inject(this)

    override fun setUpView(view: View) {
    }

}
