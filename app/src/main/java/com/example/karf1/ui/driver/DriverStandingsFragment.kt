package com.example.karf1.ui.driver

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.karf1.adapters.DriverAdapter
import com.example.karf1.databinding.FragmentDriverStandingBinding

class DriverStandingsFragment : Fragment() {

    private lateinit var viewModel: DriverStandingsViewModel
    private lateinit var binding:FragmentDriverStandingBinding
    private lateinit var  driverAdapter: DriverAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDriverStandingBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(DriverStandingsViewModel::class.java)
        driverAdapter = DriverAdapter(DriverAdapter.OnClickListener {
            viewModel.displayDriverResults(it)
        })

        viewModel.getDrivers()
        viewModel.drivers.observe(viewLifecycleOwner, Observer {
            driverAdapter.submitList(it)
            binding.driversRecyclerview.adapter = driverAdapter

        })

        viewModel.navigateToSpecificDriverDetails.observe(viewLifecycleOwner, Observer {
            if(it != null){
                this.findNavController().navigate(DriverStandingsFragmentDirections.actionNavigationDriversToDriverDetailsFragment(it))
                viewModel.displayDriverResultsCompleted()
            }
        })
        return binding.root
    }


}