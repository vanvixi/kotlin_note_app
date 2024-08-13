package com.vanvixi.noteapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.vanvixi.noteapp.databinding.ActivityMainBinding
import com.vanvixi.noteapp.fragment.SplashFragment

class MainActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add<SplashFragment>(
                    containerViewId = binding.fragmentContainerView.id,
                    args = bundleOf("key" to "value")
                )
            }
        }
    }
}