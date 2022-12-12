package com.example.khabar

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.khabar.repository.NewsRepository

// used to create an instance of ViewModel
class NewsViewModelProviderFactory(val application: Application,val newsRepository: NewsRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(application ,newsRepository) as T
    }
}