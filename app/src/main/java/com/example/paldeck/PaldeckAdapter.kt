package com.example.paldeck

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.paldeck.databinding.ItemPalListBinding

class PaldeckAdapter(val paldeckList: List<Paldeck>): RecyclerView.Adapter<PaldeckAdapter.PaldeckViewHolder>() {
    class PaldeckViewHolder(val binding: ItemPalListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaldeckViewHolder {
        val binding = ItemPalListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PaldeckViewHolder(binding)
    }

    override fun getItemCount(): Int = paldeckList.size

    override fun onBindViewHolder(holder: PaldeckViewHolder, position: Int) {
        val paldeck = paldeckList[position]
        holder.binding.apply {
            tvPaldeckName.text = paldeck.name
            tvPaldeckDescription.text = paldeck.description
            Glide.with(holder.itemView.context).load(paldeck.image).into(ivPaldeck)
        }
    }
}