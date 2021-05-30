package com.rojesh.bootcamp.learndagger.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.rojesh.bootcamp.learndagger.MyApplication
import com.rojesh.bootcamp.learndagger.di.component.ActivityComponent
import com.rojesh.bootcamp.learndagger.di.component.DaggerActivityComponent
import com.rojesh.bootcamp.learndagger.di.component.DaggerFragmentComponent
import com.rojesh.bootcamp.learndagger.di.component.FragmentComponent
import com.rojesh.bootcamp.learndagger.di.module.ActivityModule
import com.rojesh.bootcamp.learndagger.di.module.FragmentModule
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildFragmentComponent())
        super.onCreate(savedInstanceState)
        setUpObservers()
        viewModel.onCreate()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(provideLayoutId(), container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)
    }


    protected open fun setUpObservers() {
        viewModel.messageStringId.observe(this, Observer {

        })

        viewModel.messageString.observe(this, Observer {

        })
    }

    fun showMessage(message: String) =
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun setUpView(view: View)

    protected abstract fun injectDependencies(fragmentComponent: FragmentComponent)

    private fun buildFragmentComponent() =
            DaggerFragmentComponent
                    .builder()
                    .applicationComponent((context!!.applicationContext as MyApplication).applicationComponent)
                    .fragmentModule(FragmentModule(this))
                    .build()


}