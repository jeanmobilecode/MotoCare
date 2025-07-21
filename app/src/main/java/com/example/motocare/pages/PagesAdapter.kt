package com.example.motocare.pages

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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

        val context = holder.itemView.context

        val imageLayoutParams = holder.itemImage.layoutParams


        if (page.isGif) {
            imageLayoutParams.height = 300
            imageLayoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT

            holder.itemTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
            holder.itemDetails.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)

        }

        holder.itemImage.layoutParams = imageLayoutParams

        if (page.isGif) {
            Glide.with(context)
                .asGif()
                .load(page.image)
                .into(holder.itemImage)
        } else {
            Glide.with(context)
                .load(page.image)
                .into(holder.itemImage)
        }
    }
}
