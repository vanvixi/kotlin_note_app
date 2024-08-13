package com.vanvixi.noteapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vanvixi.noteapp.data.NoteModel
import com.vanvixi.noteapp.databinding.AddNoteFragmentBinding
import com.vanvixi.noteapp.databinding.NoteDetailFragmentBinding

class AddNoteFragment : BaseFragment<AddNoteFragmentBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = AddNoteFragmentBinding.inflate(inflater, container, false)


        binding.root.setOnTouchListener { _, _ -> true }
        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.btnSave.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }


}