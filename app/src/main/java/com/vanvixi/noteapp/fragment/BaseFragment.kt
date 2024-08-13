package com.vanvixi.noteapp.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import com.vanvixi.noteapp.databinding.NoteDetailFragmentBinding

abstract class BaseFragment<FragmentBinding> : Fragment() {
    protected var _binding: FragmentBinding? = null
    protected val binding get() = _binding!!

    private val logTag by lazy(LazyThreadSafetyMode.NONE) {
        this::class.java.simpleName
    }

    @CallSuper
    override fun onAttach(context: Context) {
        super.onAttach(context)
        logMsg("onAttach: context=$context")
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logMsg("onCreate: savedInstanceState=$savedInstanceState")
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logMsg("onViewCreated: view=$view")
        logMsg("onViewCreated: savedInstanceState=$savedInstanceState")
    }

    @CallSuper
    override fun onStart() {
        super.onStart()
        logMsg("onStart")
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        logMsg("onResume")
    }

    @CallSuper
    override fun onPause() {
        logMsg("onResume")

        super.onPause()
    }

    @CallSuper
    override fun onStop() {
        logMsg("onStop")
        super.onStop()
    }

    @CallSuper
    override fun onDestroyView() {
        _binding = null
        logMsg("onDestroyView")
        super.onDestroyView()
    }

    @CallSuper
    override fun onDestroy() {
        logMsg("onDestroy")
        super.onDestroy()
    }

    @CallSuper
    override fun onDetach() {
        logMsg("onDetach")
        super.onDetach()
    }

    protected fun logMsg(message: String) {
        Log.d(logTag, "$this $message")
    }
}