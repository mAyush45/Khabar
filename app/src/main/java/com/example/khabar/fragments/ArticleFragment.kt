package com.example.khabar.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.khabar.NewsActivity
import com.example.khabar.NewsViewModel
import com.example.khabar.databinding.FragmentArticleBinding
import com.example.khabar.models.Article
import com.google.android.material.snackbar.Snackbar


class ArticleFragment : Fragment() {


    lateinit var viewModel: NewsViewModel
    private var _binding: FragmentArticleBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel


        val article : Article = arguments?.getSerializable("article") as Article


        binding.webView.apply {
            webViewClient= WebViewClient()
            loadUrl(article.url.toString())
        }

        binding.fab.setOnClickListener{
            viewModel.saveArticle(article)
            Snackbar.make(view,"Article Saved Successfully", Snackbar.LENGTH_SHORT).show()
        }

    }

    //to avoid memory leaks
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}