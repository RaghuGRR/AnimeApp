package com.android.jikan.animeApp.animeList

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.jikan.animeApp.models.AnimeListData
import com.android.jikan.animeApp.models.AnimeListResponse
import com.android.jikan.animeApp.helpers.UiState
import com.android.jikan.animeApp.databinding.FragmentAnimeListBinding

class AnimeListFragment : Fragment() {

    companion object {
        fun newInstance() = AnimeListFragment()
    }

    private val viewModel: AnimeListViewModel by viewModels()
    private lateinit var binding: FragmentAnimeListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimeListBinding.inflate(inflater,container,false)
        viewModel.getAnimeList()
        binding.rvAnimeList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        val animeList = ArrayList<AnimeListData>()
        val clickListener = object : ClickListener {
            override fun onClick(position: Int, data: AnimeListData) {
                val action = AnimeListFragmentDirections.actionAnimeListFragmentToAnimeDetailFragment(
                    data
                )
                findNavController().navigate(action)
            }
        }
        binding.rvAnimeList.adapter = AnimeListAdapter(animeList,clickListener)
        viewModel.animeList.observe(viewLifecycleOwner){response ->
            when(response){
                is UiState.Error -> {}
                UiState.Idle -> {}
                UiState.Loading -> {
                    binding.loader.visibility = View.VISIBLE
                }
                is UiState.Success<*> -> {
                    binding.loader.visibility = View.GONE
                    val resp = response.result as AnimeListResponse
                    (binding.rvAnimeList.adapter as AnimeListAdapter).updateAnimeList(resp.data)
                }
            }
        }
        return binding.root
    }
}