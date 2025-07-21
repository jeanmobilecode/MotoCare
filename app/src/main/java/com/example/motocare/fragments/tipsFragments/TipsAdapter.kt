package com.example.motocare.fragments.tipsFragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.motocare.R
import com.example.motocare.data.Tip

class TipsAdapter(private val tips: List<Tip>) : RecyclerView.Adapter<TipsAdapter.TipsViewHolder>()   {

    inner class TipsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.titleTipItem)
        val description = itemView.findViewById<TextView>(R.id.descriptionTipItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tip, parent, false)
        return TipsViewHolder(view)
    }

    override fun getItemCount(): Int = tips.size

    override fun onBindViewHolder(holder: TipsViewHolder, position: Int) {
        val tip = tips[position]
        holder.title.text = tip.title
        holder.description.text = tip.description
    }
}