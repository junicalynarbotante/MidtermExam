package com.example.arbotanteexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.arbotanteexam.databinding.ActivityMainBinding
import com.example.arbotanteexam.fragments.OneFragment
import com.example.arbotanteexam.fragments.TwoFragment

class MainActivity : AppCompatActivity(), OneFragment.OneFragmentInterface {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace(binding.fragmentContainerT.id, OneFragment()) // top fragment
        fragmentManager.commit()


    }

    override fun modifyUserName() {
        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace(binding.fragmentContainerB.id, TwoFragment()) // top fragment
        fragmentManager.commit()
    }
}