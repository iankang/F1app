package com.example.karf1.ui.constructors

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.karf1.R
import com.example.karf1.databinding.ConstructorsStandingDetailFragmentBinding

class ConstructorsStandingDetailFragment : Fragment() {


    private lateinit var viewModel: ConstructorsStandingDetailViewModel
    private lateinit var binding: ConstructorsStandingDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ConstructorsStandingDetailFragmentBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(ConstructorsStandingDetailViewModel::class.java)

        val constructorInfo = ConstructorsStandingDetailFragmentArgs.fromBundle(requireArguments()).selectedConstructor
        binding.detailString.text = constructorInfo.toString()
        return binding.root
    }


}