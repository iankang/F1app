package com.example.karf1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.karf1.models.DriverStandings
import com.example.karf1.databinding.DriverListItemBinding

class DriverAdapter(private val onClickListener: OnClickListener): ListAdapter<DriverStandings, DriverAdapter.DriverViewHolder>(
    diffCallBack
) {

    class DriverViewHolder(private var binding: DriverListItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: DriverStandings){
            binding.driver = item
            binding.executePendingBindings()
        }
    }

    companion object diffCallBack: DiffUtil.ItemCallback<DriverStandings>(){
        override fun areItemsTheSame(oldItem: DriverStandings, newItem: DriverStandings): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: DriverStandings,
            newItem: DriverStandings
        ): Boolean {
           return oldItem.driver.driverId == newItem.driver.driverId
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
        return DriverViewHolder(
            DriverListItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: DriverViewHolder, position: Int) {
        val driverStanding = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(driverStanding)
        }
        holder.bind(driverStanding)
    }

    class OnClickListener(val clickListener:(driverStandings: DriverStandings) -> Unit){
        fun onClick(driverStandings: DriverStandings) = clickListener(driverStandings)
    }
}