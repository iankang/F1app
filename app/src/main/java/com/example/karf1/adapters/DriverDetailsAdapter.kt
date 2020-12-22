package com.example.karf1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.karf1.databinding.DriverResultsListItemBinding
import com.example.karf1.models.DriverResults
import com.example.karf1.models.RacesDriverResults

class DriverDetailsAdapter:ListAdapter<RacesDriverResults,DriverDetailsAdapter.DriverDetailViewHolder>(racesDriverDiffUtil) {

   companion object racesDriverDiffUtil:DiffUtil.ItemCallback<RacesDriverResults>(){
       override fun areItemsTheSame(oldItem: RacesDriverResults, newItem: RacesDriverResults): Boolean {
           return oldItem == newItem
       }

       override fun areContentsTheSame(oldItem: RacesDriverResults, newItem: RacesDriverResults): Boolean {
           return oldItem.round == newItem.round
       }

   }

    class DriverDetailViewHolder(private val binding:DriverResultsListItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(racesDriverResults: RacesDriverResults){
            binding.racesDriverResult = racesDriverResults
            binding.driverInfo = racesDriverResults.results[0].driver
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverDetailViewHolder {
        return DriverDetailViewHolder(DriverResultsListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: DriverDetailViewHolder, position: Int) {
        var item = getItem(position)
        holder.bind(item)

    }
}