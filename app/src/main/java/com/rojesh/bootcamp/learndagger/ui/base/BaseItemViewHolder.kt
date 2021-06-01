package com.rojesh.bootcamp.learndagger.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.rojesh.bootcamp.learndagger.MyApplication
import com.rojesh.bootcamp.learndagger.di.component.DaggerViewHolderComponent
import com.rojesh.bootcamp.learndagger.di.module.ViewHolderModule
import javax.inject.Inject

abstract class BaseItemViewHolder<T : Any, VM : BaseItemViewModel<T>>(
        @LayoutRes layout: Int, parent: ViewGroup
) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false)),
        LifecycleOwner {

    init {
        onCreate()
    }

    override fun getLifecycle(): Lifecycle = lifecycleRegistry

    @Inject
    lateinit var viewModel: VM

    @Inject
    lateinit var lifecycleRegistry: LifecycleRegistry

    open fun bind(data: T) {
        viewModel.updateDate(data)
    }

    protected fun onCreate() {
        injectDependencies(buildViewHolderComponent() as DaggerViewHolderComponent)
        lifecycleRegistry.setCurrentState(Lifecycle.State.INITIALIZED)
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED)
        setUpObservers()
        setUpView(itemView)
    }

    fun onStart() {
        lifecycleRegistry.setCurrentState(Lifecycle.State.STARTED)
        lifecycleRegistry.setCurrentState(Lifecycle.State.RESUMED)
    }

    fun onStop() {
        lifecycleRegistry.setCurrentState(Lifecycle.State.STARTED)
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED)
    }

    fun onDestroy() {
        lifecycleRegistry.setCurrentState(Lifecycle.State.DESTROYED)
    }


    protected open fun setUpObservers() {
        viewModel.messageStringId.observe(this, Observer {

        })

        viewModel.messageString.observe(this, Observer {

        })
    }

    fun showMessage(message: String) =
            Toast.makeText(itemView.context, message, Toast.LENGTH_SHORT).show()

    fun showMessage(@StringRes resId: Int) = showMessage(itemView.context.getString(resId))

    protected abstract fun setUpView(view: View)

    protected abstract fun injectDependencies(viewHolderComponent: DaggerViewHolderComponent)

    private fun buildViewHolderComponent() =
            DaggerViewHolderComponent
                    .builder()
                    .applicationComponent((itemView.context.applicationContext as MyApplication).applicationComponent)
                    .viewHolderModule(ViewHolderModule(this))
                    .build()

}