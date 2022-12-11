package com.example.khabar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.khabar.databinding.ActivityNewsBinding
import com.example.khabar.fragments.BreakingNewsFragment
import com.example.khabar.fragments.SavedNewsFragment
import com.example.khabar.fragments.SearchNewsFragment

class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityNewsBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        replaceFragment(BreakingNewsFragment())



        binding.bottomNavigationView.setOnItemReselectedListener{

            when(it.itemId) {
                R.id.breakingNewsFragment -> replaceFragment(BreakingNewsFragment())
                R.id.savedNewsFragment -> replaceFragment(SavedNewsFragment())
                R.id.searchNewsFragment -> replaceFragment(SearchNewsFragment())

                else -> {
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager= supportFragmentManager
        val fragmentTransaction= fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.flFragment,fragment)
        fragmentTransaction.commit()
    }
}


//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
//        val navController = navHostFragment.navController
//
////        val navController=findNavController(R.id.newsNavHostFragment)
//        binding.bottomNavigationView.setupWithNavController(navController)