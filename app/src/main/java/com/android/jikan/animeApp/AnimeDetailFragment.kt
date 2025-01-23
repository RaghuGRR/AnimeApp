package com.android.jikan.animeApp

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.jikan.animeApp.databinding.FragmentAnimeDetailBinding

class AnimeDetailFragment : Fragment() {

    companion object {
        fun newInstance() = AnimeDetailFragment()
    }

    private val viewModel: AnimeDetailViewModel by viewModels()
    private lateinit var binding: FragmentAnimeDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimeDetailBinding.inflate(inflater,container,false)
        val animeData = arguments?.let{
            AnimeDetailFragmentArgs.fromBundle(it).animeData
        }
        binding.tvAnimeTitleDetail.text = animeData?.title
        binding.tvSynopsis.text = animeData?.synopsis
        binding.tvRating.text = animeData?.score.toString()
        binding.tvEpisodeCount.text = animeData?.episodes.toString()
        binding.tvgenre.text = animeData?.genres?.joinToString(",") { it.name }
        if(animeData?.trailer != null){
//            binding.trailerExoPlayer.player =
        }
        return binding.root
    }
}