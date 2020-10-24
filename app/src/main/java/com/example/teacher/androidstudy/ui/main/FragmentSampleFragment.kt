package com.example.teacher.androidstudy.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.teacher.androidstudy.R

class FragmentSampleFragment : Fragment() {

    companion object {
        fun newInstance() = FragmentSampleFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("FragmentSampleFragment","onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i("FragmentSampleFragment","onCreateView")
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("FragmentSampleFragment","onActivityCreated")
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()
        Log.i("FragmentSampleFragment","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("FragmentSampleFragment","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("FragmentSampleFragment","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("FragmentSampleFragment","onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("FragmentSampleFragment","onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("FragmentSampleFragment","onDestroy")
    }

}