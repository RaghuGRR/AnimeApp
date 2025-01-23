package com.android.jikan.animeApp

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import com.android.jikan.animeApp.databinding.ActivityMainBinding

class AnimeAppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val navHost: NavHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.anime_activity_nav_host_fragment) as NavHostFragment
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}