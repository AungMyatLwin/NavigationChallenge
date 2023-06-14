package com.practice.navigationchallenge

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.findNavController
import com.practice.navigationchallenge.databinding.FragmentEmailBinding

class EmailFragment : Fragment(){
    private lateinit var binding:FragmentEmailBinding
    private val args= NameFragmentArgs.fromBundle(arguments)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)
        Log.d("args ", "onCreateView: ${args.signUpName}")

        binding.submitBtn.setOnClickListener {
            val arrays = arrayListOf(args.signUpName,binding.inputEmail.text.toString())

            val action= EmailFragmentDirections.actionEmailFragmentToWelcomeFragment()
            it.findNavController().navigate(action)
        }
        return binding.root
    }
}