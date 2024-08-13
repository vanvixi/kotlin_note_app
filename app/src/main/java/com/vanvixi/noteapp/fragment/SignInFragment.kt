package com.vanvixi.noteapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.vanvixi.noteapp.R
import com.vanvixi.noteapp.databinding.SignInFragmentBinding

class SignInFragment : BaseFragment<SignInFragmentBinding>() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = SignInFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            parentFragmentManager.commit {
                replace<NoteFragment>(containerViewId = R.id.fragmentContainerView)
            }
        }

        binding.txtHintSignUp.setOnClickListener {
            parentFragmentManager.commit {
                add<SignUpFragment>(
                    containerViewId = R.id.fragmentContainerView,
                    args = bundleOf("key" to "value")
                )
                addToBackStack("LoginFragment")
            }
        }
    }
}