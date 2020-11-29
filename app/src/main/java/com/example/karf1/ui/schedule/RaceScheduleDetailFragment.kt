package com.example.karf1.ui.schedule

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.karf1.R
import com.example.karf1.adapters.RaceScheduleDetailAdapter
import com.example.karf1.databinding.RaceScheduleDetailFragmentBinding

class RaceScheduleDetailFragment : Fragment() {


    private lateinit var viewModel: RaceScheduleDetailViewModel
    private lateinit var binding:RaceScheduleDetailFragmentBinding
    private lateinit var adapter:RaceScheduleDetailAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = RaceScheduleDetailFragmentBinding.inflate(inflater)

        val passedValue = RaceScheduleDetailFragmentArgs.fromBundle(requireArguments()).selectedCircuit

        val viewModelFactory = RaceScheduleDetailViewModelFactory(passedValue)
        viewModel = ViewModelProvider(this, viewModelFactory).get(RaceScheduleDetailViewModel::class.java)

        viewModel.getCircuitResults(passedValue)

        adapter =  RaceScheduleDetailAdapter()
        binding.resultsTable.adapter = adapter
        viewModel.circuitResults.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        return binding.root
    }


}