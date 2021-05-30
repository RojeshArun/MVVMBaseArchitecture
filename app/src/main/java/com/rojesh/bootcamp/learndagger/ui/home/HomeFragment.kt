package com.rojesh.bootcamp.learndagger.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.rojesh.bootcamp.learndagger.MyApplication
import com.rojesh.bootcamp.learndagger.R
import com.rojesh.bootcamp.learndagger.di.component.DaggerFragmentComponent
import com.rojesh.bootcamp.learndagger.di.module.FragmentModule
import javax.inject.Inject

class HomeFragment : Fragment() {

    companion object {

        val TAG = "HomeFragment"

        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvMessage = view.findViewById<TextView>(R.id.tv_message)
        tvMessage.text = viewModel.someData
    }

    private// to suppress null pointer exception warning
    fun getDependencies() {
        DaggerFragmentComponent
                .builder()
                .applicationComponent((context!!
                        .applicationContext as MyApplication).applicationComponent)
                .fragmentModule(FragmentModule(this)) // this is shown as deprecated as no instance provided by it is being injected
                .build()
                .inject(this)
    }

}
