package com.example.karf1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.karf1.databinding.RaceScheduleListItemBinding
import com.example.karf1.models.Races

class RaceScheduleAdapter(private val onClickListener: OnClickListener) :ListAdapter<Races, RaceScheduleAdapter.RaceScheduleViewHolder>(
    raceDiffUtil
){

    class RaceScheduleViewHolder(private var binding: RaceScheduleListItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:Races){
            binding.race = item
            binding
            binding.executePendingBindings()
        }
    }


    companion object raceDiffUtil: DiffUtil.ItemCallback<Races>(){
        override fun areItemsTheSame(oldItem: Races, newItem: Races): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Races, newItem: Races): Boolean {
            return oldItem.circuit.circuitId == newItem.circuit.circuitId
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RaceScheduleViewHolder {
        return RaceScheduleViewHolder(RaceScheduleListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RaceScheduleViewHolder, position: Int) {
        var race = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(race)
        }
        holder.bind(race)
    }

    class OnClickListener(val clickListener: (races:Races) -> Unit){
        fun onClick(races: Races) = clickListener(races)
    }
}