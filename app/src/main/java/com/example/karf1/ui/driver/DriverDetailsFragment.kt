package com.example.karf1.ui.driver

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.karf1.adapters.DriverDetailsAdapter
import com.example.karf1.databinding.DriverDetailsFragmentBinding
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class DriverDetailsFragment : Fragment() {



    private lateinit var viewModel: DriverDetailsViewModel
    private lateinit var binding:DriverDetailsFragmentBinding
    private lateinit var driverDetailsAdapter:DriverDetailsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DriverDetailsFragmentBinding.inflate(inflater)


        val arguments = DriverDetailsFragmentArgs.fromBundle(requireArguments()).driverDetails

        driverDetailsAdapter = DriverDetailsAdapter()
        binding.driverResultsRecyclerView.adapter = driverDetailsAdapter

        var viewModelFactory = DriverDetailViewModelFactory(arguments)
        viewModel = ViewModelProvider(this,viewModelFactory).get(DriverDetailsViewModel::class.java)



        var postitionLineBar = ArrayList<Entry>()
        var circuits = ArrayList<String>()

        viewModel.getDriverDetails(arguments)
        viewModel.driverDetailResults.observe(viewLifecycleOwner, Observer {
            Log.e("driverDetails",it.toString())
            it.forEach {
                var count = 0
                circuits.add(it.circuit.circuitName)
                it.results.forEach {
                    postitionLineBar.add(Entry(it.position.toFloat(),count.toFloat()))
                    count += 1
                    Log.e("driver",it.position)
                }
            }
            driverDetailsAdapter.submitList(it)
        })
        val lineDataSet = LineDataSet(postitionLineBar,"Position In Race")
        var lineData = LineData(lineDataSet)
        binding.lineChart.data = lineData
        return binding.root
    }


}