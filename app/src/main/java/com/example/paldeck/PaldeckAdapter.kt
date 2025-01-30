package com.example.paldeck

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.paldeck.databinding.ItemPalListBinding

class PaldeckAdapter(val paldeckList: List<Paldeck>, val listener: OnItemClickListener): RecyclerView.Adapter<PaldeckAdapter.PaldeckViewHolder>() {
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
            paldeck.elements.forEach {
                when (it) {
                    Element.FIRE -> ivFire.visibility = View.VISIBLE
                    Element.WATER -> ivWater.visibility = View.VISIBLE
                    Element.GRASS -> ivGrass.visibility = View.VISIBLE
                    Element.ELECTRIC -> ivElectric.visibility = View.VISIBLE
                    Element.ICE -> ivIce.visibility = View.VISIBLE
                    Element.GROUND -> ivGround.visibility = View.VISIBLE
                    Element.DARK -> ivDark.visibility = View.VISIBLE
                    Element.DRAGON -> ivDragon.visibility = View.VISIBLE
                    Element.NEUTRAL -> ivNeutral.visibility = View.VISIBLE
                }
            }
            Glide.with(holder.itemView.context).load(paldeck.image).into(ivPaldeck)

            root.setOnClickListener {
                listener.onItemClick(paldeck)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(paldeck: Paldeck)
    }
}