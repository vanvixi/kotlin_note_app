package com.vanvixi.noteapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.vanvixi.noteapp.R
import com.vanvixi.noteapp.databinding.SplashFragmentBinding

class SplashFragment : BaseFragment<SplashFragmentBinding>() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = SplashFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Thread {
            Thread.sleep(1000)
            parentFragmentManager.commit {
                replace<SignInFragment>(
                    containerViewId = R.id.fragmentContainerView,
                    args = bundleOf("key" to "value")
                )
            }
        }.start()
    }
}