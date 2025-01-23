package com.android.jikan.animeApp.animeDetail

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import com.android.jikan.animeApp.databinding.FragmentAnimeDetailBinding
import com.bumptech.glide.Glide

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
            val url = animeData.trailer.embedUrl?:animeData.trailer.url
            if(url!=null){
                val webView = binding.exoPlayerView
                webView.settings.javaScriptEnabled = true
                webView.loadUrl(url)
                webView.webChromeClient = WebChromeClient()


            }
            else{
                binding.playerView.visibility = View.GONE
                binding.trailerImage.visibility = View.VISIBLE
                Glide.with(requireContext()).load(animeData.trailer.images.largeImageUrl).into(binding.trailerImage)
            }
        }
        return binding.root
    }
}