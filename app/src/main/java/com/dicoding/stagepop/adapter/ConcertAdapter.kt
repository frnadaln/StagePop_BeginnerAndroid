package com.dicoding.stagepop.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.stagepop.Concert
import com.dicoding.stagepop.R
import com.dicoding.stagepop.DetailActivity

class ConcertAdapter(private val context: Context, private val concertList: List<Concert>) : RecyclerView.Adapter<ConcertAdapter.ConcertViewHolder>() {

    inner class ConcertViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.textConcertTitle)
        val descriptionTextView: TextView = itemView.findViewById(R.id.textConcertDescription)
        val imageView: ImageView = itemView.findViewById(R.id.imageConcert)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val concert = concertList[position]
                    val intent = Intent(context, DetailActivity::class.java).apply {
                        putExtra("key_concert", concert)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConcertViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_concert, parent, false)
        return ConcertViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConcertViewHolder, position: Int) {
        val concert = concertList[position]
        holder.titleTextView.text = concert.title
        holder.descriptionTextView.text = concert.description
        holder.imageView.setImageResource(concert.imageResId)
    }

    override fun getItemCount(): Int {
        return concertList.size
    }
}
