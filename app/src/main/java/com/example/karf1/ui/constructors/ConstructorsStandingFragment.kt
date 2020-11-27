package com.example.karf1.ui.constructors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.karf1.R
import com.example.karf1.adapters.ConstructorAdapter
import com.example.karf1.databinding.ConstructorsFragmentBinding

class ConstructorsStandingFragment : Fragment() {


    private lateinit var viewModel: ConstructorsStandingViewModel
    private lateinit var binding: ConstructorsFragmentBinding
    private lateinit var adapter: ConstructorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ConstructorsStandingViewModel::class.java)
        binding = ConstructorsFragmentBinding.inflate(inflater)

        adapter = ConstructorAdapter(ConstructorAdapter.OnClickListener {
            viewModel.displayConstructorDetails(it)
        })
        binding.constructorRecycler.adapter = adapter

        viewModel.getConstructors()
        viewModel.constructor.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        viewModel.navigateToSelectedConstructor.observe(viewLifecycleOwner, Observer {
            if (it != null) {

                this.findNavController().navigate(ConstructorsStandingFragmentDirections.actionNavigationConstructorsToConstructorsStandingDetailFragment(it))
                viewModel.displayConstructorDetailsComplete()
            }
        })

        return binding.root
    }
}