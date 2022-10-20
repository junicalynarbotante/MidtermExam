package com.example.arbotanteexam.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.arbotanteexam.PREFERENCE_NAME
import com.example.arbotanteexam.USER_NAME
import com.example.arbotanteexam.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {
    private lateinit var binding : FragmentTwoBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentTwoBinding.inflate(inflater,container,false)
        sharedPreferences = requireActivity().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.username.text = String.format("USERNAME: %s",sharedPreferences.getString(
            USER_NAME,""))
    }
}