package com.example.motocare.pages

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.motocare.R


class PagesAdapter(private val pages: List<Pages>) : RecyclerView.Adapter<PagesAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.tvtitle)
        val itemDetails: TextView = itemView.findViewById(R.id.tvabout)
        val itemImage: ImageView = itemView.findViewById(R.id.ivImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pager2ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_page, parent, false)
        return Pager2ViewHolder(view)
    }

    override fun getItemCount(): Int = pages.size

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        val page = pages[position]
        holder.itemTitle.text = page.title
        holder.itemDetails.text = page.details
        holder.itemImage.setImageResource(page.image)
    }
}
