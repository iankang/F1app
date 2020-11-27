package com.example.karf1.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.karf1.R
import com.example.karf1.adapters.RaceScheduleAdapter
import com.example.karf1.databinding.RaceScheduleFragmentBinding

class RaceScheduleFragment : Fragment() {

    private lateinit var viewModel: RaceScheduleViewModel
    private lateinit var binding: RaceScheduleFragmentBinding
    private lateinit var adapter:RaceScheduleAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = RaceScheduleFragmentBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(RaceScheduleViewModel::class.java)

        adapter = RaceScheduleAdapter()
        binding.raceRecyclerView.adapter = adapter
        viewModel.getSchedule()
        viewModel.races.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        return binding.root
    }
}