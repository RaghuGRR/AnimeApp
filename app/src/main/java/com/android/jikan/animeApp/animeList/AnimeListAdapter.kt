package com.android.jikan.animeApp.animeList

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.jikan.animeApp.databinding.AnimeListItemBinding
import com.android.jikan.animeApp.helpers.loadImage
import com.android.jikan.animeApp.models.AnimeListData

class AnimeListAdapter(private val animeList: ArrayList<AnimeListData>, val clickListener: ClickListener) : RecyclerView.Adapter<AnimeListAdapter.ViewHolder>() {
    inner class ViewHolder(itemBinding:AnimeListItemBinding) : RecyclerView.ViewHolder(itemBinding.root){
        var ivAnimeImage = itemBinding.ivAnimeImage
        var tvAnimeTitle = itemBinding.tvAnimeTitle
        var tvAnimeEpisodes = itemBinding.tvAnimeEpisodes
        var tvAnimeRating = itemBinding.tvAnimeRating
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AnimeListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("TAG", "onBindViewHolder: title:${animeList[position].title} episode:${animeList[position].episodes} rating:${animeList[position].score}")
        holder.tvAnimeTitle.text = animeList[position].title
        holder.tvAnimeEpisodes.text = "${animeList[position].episodes} Episodes"
        holder.tvAnimeRating.text = "${animeList[position].score} Rating"
        loadImage(animeList[position].images.jpg.imageUrl,holder.ivAnimeImage)
        holder.itemView.setOnClickListener {
            clickListener.onClick(position,animeList[position])
        }
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    internal fun updateAnimeList(animeList: List<AnimeListData>){
        this.animeList.clear()
        this.animeList.addAll(animeList)
        notifyDataSetChanged()
    }
}

interface ClickListener{
    fun onClick(position: Int,data: AnimeListData)
}
