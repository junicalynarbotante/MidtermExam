package com.example.arbotanteexam.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.arbotanteexam.PREFERENCE_NAME
import com.example.arbotanteexam.R
import com.example.arbotanteexam.USER_NAME
import com.example.arbotanteexam.databinding.FragmentOneBinding
import com.example.arbotanteexam.databinding.FragmentTwoBinding


class OneFragment : Fragment(), View.OnClickListener {
    private lateinit var binding : FragmentOneBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var oneFragmentInterface : OneFragmentInterface

    interface OneFragmentInterface{
        fun modifyUserName()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        oneFragmentInterface = context as OneFragmentInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentOneBinding.inflate(inflater,container,false)
        sharedPreferences = requireActivity().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveUsername.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        val userlength = binding.enterUsername.text.length
        binding.enterUsername.hint = "USERNAME"

        if(binding.enterUsername.text.isEmpty()){
            binding.enterUsername.error = "Required"
            return
        }
        else if(userlength<6){
            binding.enterUsername.error = "Please enter at least 6 characters"
            return
        } else {
            val editor = sharedPreferences.edit()
            editor.putString(USER_NAME, binding.enterUsername.text.toString())
            editor.apply()
            oneFragmentInterface.modifyUserName()
        }
    }
}