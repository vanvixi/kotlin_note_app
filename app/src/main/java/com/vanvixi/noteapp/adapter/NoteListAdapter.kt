package com.vanvixi.noteapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vanvixi.noteapp.data.NoteModel
import com.vanvixi.noteapp.databinding.NoteItemLayoutBinding

object NoteDiffCallback : DiffUtil.ItemCallback<NoteModel>() {
    override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
        return oldItem == newItem
    }
}

class NoteListAdapter(
    private val onItemClick: (NoteModel) -> Unit
) : ListAdapter<NoteModel, NoteListAdapter.NoteViewHolder>(NoteDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): NoteViewHolder {
        return NoteViewHolder(
            NoteItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }


   inner class NoteViewHolder(private val binding: NoteItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val pos = adapterPosition
                if (pos == RecyclerView.NO_POSITION) {
                    return@setOnClickListener
                }

                onItemClick(getItem(pos))
            }
        }
        fun bind(note: NoteModel) {
            binding.run {
                txtTitle.text = note.title
                txtContent.text = note.content
            }
        }
    }
}