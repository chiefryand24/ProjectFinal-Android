package com.asep.tugas_final_android.ui.ListBerita

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asep.tugas_final_android.R
import com.asep.tugas_final_android.model.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_berita.view.*

class BeritaAdapter(private val listener: BeritaAdapter.Listener): RecyclerView.Adapter<BeritaAdapter.Holder>() {
    interface Listener {
        fun onBeritaClick(article: Article)
    }

    private var listBerita = mutableListOf<Article>()

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(article: Article, listener: Listener) {
            with(itemView) {
                var img = ""+article.urlToImage
                if(img != "null" && img != "") {
                    Picasso.get()
                        .load(img)
                        .into(beritaThumb)
                }
                beritaTitle.text = article.title
                beritaSource.text = article.source.name
            }
        }
    }

    fun setData(list: MutableList<Article>) {
        this.listBerita = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_berita, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(listBerita[position], listener)
    }

    override fun getItemCount(): Int {
        return listBerita.size
    }


}