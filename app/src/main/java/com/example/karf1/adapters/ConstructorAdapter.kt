package com.example.karf1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.karf1.models.ConstructorStandings
import com.example.karf1.databinding.ConstructorListItemBinding

class ConstructorAdapter(private val onClickListener: OnClickListener): ListAdapter<ConstructorStandings,ConstructorAdapter.ConstructorViewHolder>(constructorDiffUtil){

    class ConstructorViewHolder(private var binding: ConstructorListItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: ConstructorStandings){
            binding.constructor = item
            binding.executePendingBindings()
        }
    }

    companion object constructorDiffUtil:androidx.recyclerview.widget.DiffUtil.ItemCallback<ConstructorStandings>(){
        override fun areItemsTheSame(
            oldItem: ConstructorStandings,
            newItem: ConstructorStandings
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ConstructorStandings,
            newItem: ConstructorStandings
        ): Boolean {
            return oldItem.constructor.constructorId == newItem.constructor.constructorId
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConstructorViewHolder {
        return ConstructorViewHolder(ConstructorListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ConstructorViewHolder, position: Int) {
        var item = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onCLick(item)
        }
        holder.bind(item)

    }

    class OnClickListener(val clickListener:(constructorStandings: ConstructorStandings) -> Unit){
        fun onCLick(constructorStandings: ConstructorStandings) = clickListener(constructorStandings)
    }
}