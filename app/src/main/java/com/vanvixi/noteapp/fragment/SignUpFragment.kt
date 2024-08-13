package com.vanvixi.noteapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.vanvixi.noteapp.R
import com.vanvixi.noteapp.databinding.SignUpFragmentBinding

class SignUpFragment : BaseFragment<SignUpFragmentBinding>() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = SignUpFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.btnCreateAcc.setOnClickListener{
            parentFragmentManager.commit {
                replace<NoteFragment>(containerViewId = R.id.fragmentContainerView)
            }
        }

        binding.txtHintSignIn.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}