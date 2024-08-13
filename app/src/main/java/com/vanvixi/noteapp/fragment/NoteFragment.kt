package com.vanvixi.noteapp.fragment

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vanvixi.noteapp.R
import com.vanvixi.noteapp.adapter.NoteListAdapter
import com.vanvixi.noteapp.data.NoteModel
import com.vanvixi.noteapp.databinding.NoteFragmentBinding
import java.util.*

class NoteFragment : BaseFragment<NoteFragmentBinding>() {
    private val noteAdapter by lazy(LazyThreadSafetyMode.NONE) {
        NoteListAdapter(
            onItemClick = ::onItemClick
        )
    }

    private val notes = listOf(
        NoteModel(id = 0, title = "🛒 Shopping List", content = "Buy milk, eggs, and bread", createAt = Date()),
        NoteModel(id = 1, title = "🏋️‍♂️ Workout Plan", content = "Morning jog and evening yoga", createAt = Date()),
        NoteModel(id = 2, title = "📝 Meeting Notes", content = "Discuss project milestones", createAt = Date()),
        NoteModel(id = 3, title = "🍝 Recipe", content = "Pasta with tomato sauce and basil", createAt = Date()),
        NoteModel(id = 4, title = "✈️ Travel Plans", content = "Visit Tokyo and Kyoto", createAt = Date()),
        NoteModel(id = 5, title = "🎂 Birthday Reminder", content = "Buy a gift for John's birthday", createAt = Date()),
        NoteModel(id = 6, title = "📚 Book List", content = "Read '1984' by George Orwell", createAt = Date()),
        NoteModel(id = 7, title = "🛍️ Groceries", content = "Get fresh fruits and vegetables", createAt = Date()),
        NoteModel(id = 8, title = "📖 Homework", content = "Complete math exercises", createAt = Date()),
        NoteModel(id = 9, title = "🎵 Event", content = "Attend concert on Friday", createAt = Date()),
        NoteModel(id = 10, title = "👟 Shopping", content = "Get a new pair of running shoes", createAt = Date()),
        NoteModel(id = 11, title = "💡 Ideas", content = "Brainstorm new app features", createAt = Date()),
        NoteModel(id = 12, title = "📊 Work Tasks", content = "Finish the quarterly report", createAt = Date()),
        NoteModel(id = 13, title = "🍽️ Diet Plan", content = "Eat more protein and less sugar", createAt = Date()),
        NoteModel(id = 14, title = "🏞️ Weekend Plans", content = "Go hiking in the mountains", createAt = Date()),
        NoteModel(
            id = 15,
            title = "🎬 Movies to Watch",
            content = "Watch 'Inception' and 'Interstellar'",
            createAt = Date()
        ),
        NoteModel(id = 16, title = "🦷 Appointment", content = "Dentist appointment on Monday", createAt = Date()),
        NoteModel(id = 17, title = "🧹 Cleaning", content = "Clean the house this weekend", createAt = Date()),
        NoteModel(
            id = 18,
            title = "💻 Tech Conference",
            content = "Attend the upcoming tech conference",
            createAt = Date()
        ),
        NoteModel(
            id = 19,
            title = "📚 Learning",
            content = "Google Play Protect, regular security updates and control over how your data is shared. We’re dedicated to securing Android’s 2.5 billion+ active devices every day and keeping information private.\n" +
                    "\n" +
                    "Screen readers, speech-to-text and some of the newest ways to experience the world your way.\n" +
                    "\n" +
                    "Choices for work, gaming, 5G streaming and anything else. There are over 24,000 phones and tablets that run on Android globally. So no matter what you’re looking for, there’s something for you.",
            createAt = Date()
        )
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = NoteFragmentBinding.inflate(inflater, container, false)
        setUpNotesView()
        noteAdapter.submitList(notes)

        binding.btnAddNote.setOnClickListener {
            parentFragmentManager.commit {
                add<AddNoteFragment>(containerViewId = R.id.fragmentContainerView)
                addToBackStack("NoteDetail")
            }
        }

        return binding.root
    }


    private fun setUpNotesView() {
        binding.recyclerView.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = noteAdapter
            val color = ContextCompat.getColor(context, R.color.divider)
            val thickness = resources.getDimensionPixelSize(R.dimen.divider_thickness)
            addItemDecoration(CustomDividerItemDecoration(color, thickness))
        }
    }

    private fun onItemClick(noteModel: NoteModel) {
        parentFragmentManager.commit {
            add<NoteDetailFragment>(
                containerViewId = R.id.fragmentContainerView,
                args = bundleOf("noteModel" to noteModel)
            )
            addToBackStack("NoteDetail")
        }
    }

    class CustomDividerItemDecoration(
        color: Int,
        private val thickness: Int,
    ) : RecyclerView.ItemDecoration() {

        private val paint = Paint()

        init {
            paint.color = color
            paint.style = Paint.Style.FILL
        }

        override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            val left = parent.paddingLeft
            val right = parent.width - parent.paddingRight

            for (i in 0 until parent.childCount) {
                val child = parent.getChildAt(i)
                val params = child.layoutParams as RecyclerView.LayoutParams

                val top = child.bottom + params.bottomMargin
                val bottom = top + thickness

                c.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), paint)
            }
        }

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            outRect.bottom = thickness
        }
    }
}