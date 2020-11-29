package com.example.karf1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.karf1.databinding.RaceScheduleListItemBinding
import com.example.karf1.databinding.ResultsTableBinding
import com.example.karf1.models.CircuitResults

class RaceScheduleDetailAdapter:ListAdapter<CircuitResults,RaceScheduleDetailAdapter.RaceScheduleResultViewHolder>(RaceScheduleDetailDiffUtil) {

    companion object RaceScheduleDetailDiffUtil:DiffUtil.ItemCallback<CircuitResults>(){
        override fun areItemsTheSame(oldItem: CircuitResults, newItem: CircuitResults): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CircuitResults, newItem: CircuitResults): Boolean {
            return oldItem.driver.driverId == newItem.driver.driverId
        }

    }

    class RaceScheduleResultViewHolder(private val binding:ResultsTableBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(circuitResults: CircuitResults){
            binding.result = circuitResults
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RaceScheduleResultViewHolder {
        return RaceScheduleResultViewHolder(ResultsTableBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RaceScheduleResultViewHolder, position: Int) {
       var item = getItem(position)
        holder.bind(item)

    }


}