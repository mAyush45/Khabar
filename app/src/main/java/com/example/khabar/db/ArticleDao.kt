package com.example.khabar.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.khabar.models.Article


@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article) : Long

    @Query("Select * FROM articles") //live data objects do not work with suspend functions
     fun getAllArticles(): LiveData<List<Article>>

     @Delete
     suspend fun deleteArticle(article: Article)




}