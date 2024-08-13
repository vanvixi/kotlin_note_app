package com.vanvixi.noteapp.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.vanvixi.noteapp.R

@SuppressLint("ResourceType")
class PrimaryButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatButton(context, attrs, defStyleAttr) {

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.PrimaryButton,
            0, 0
        ).apply {
            try {
                minHeight = 60
                background = getDrawable(R.drawable.primary_btn_bgr)

                text = getString(R.styleable.PrimaryButton_label)
                textSize = 20F
                typeface = Typeface.create(typeface, Typeface.BOLD)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                recycle()
            }
        }
    }
}