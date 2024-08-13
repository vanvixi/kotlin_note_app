package com.vanvixi.noteapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vanvixi.noteapp.data.NoteModel
import com.vanvixi.noteapp.databinding.NoteDetailFragmentBinding

class NoteDetailFragment : BaseFragment<NoteDetailFragmentBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = NoteDetailFragmentBinding.inflate(inflater, container, false)
        val noteModel: NoteModel? = arguments?.getParcelable("noteModel")

        Log.i("NoteModel", noteModel.toString())

        binding.txtTitle.text = noteModel?.title
        binding.txtCreateAt.text = noteModel?.createAtFormatted
        binding.txtContent.text = noteModel?.content

        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }


}