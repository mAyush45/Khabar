package com.example.khabar

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.khabar.databinding.ActivityNewsBinding
import com.example.khabar.db.ArticleDatabase
import com.example.khabar.fragments.BreakingNewsFragment
import com.example.khabar.fragments.SavedNewsFragment
import com.example.khabar.fragments.SearchNewsFragment
import com.example.khabar.repository.NewsRepository

class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityNewsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        replaceFragment(BreakingNewsFragment())


        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application,newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)


        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.breakingNewsFragment -> replaceFragment(BreakingNewsFragment())
                R.id.savedNewsFragment -> replaceFragment(SavedNewsFragment())
                R.id.searchNewsFragment -> replaceFragment(SearchNewsFragment())

                else -> {
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.flFragment, fragment)
        fragmentTransaction.commit()
    }
}

