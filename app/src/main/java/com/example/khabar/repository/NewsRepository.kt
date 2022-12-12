package com.example.khabar.repository

import com.example.khabar.api.RetrofitInstance
import com.example.khabar.db.ArticleDatabase
import com.example.khabar.models.Article


// directly queries our API for breaking news
class NewsRepository(val db: ArticleDatabase) {

    suspend fun getBreakingNews(countryCode:String, pageNumber: Int)=
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun searchNews(searchQuery : String, pageNumber: Int)=
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article: Article)= db.getArticleDao().upsert(article)

    fun getSavedNews()= db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article)= db.getArticleDao().deleteArticle(article)



}