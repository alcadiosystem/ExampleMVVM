package com.alcadiosystem.examplemvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.alcadiosystem.examplemvvm.databinding.ActivityMainBinding
import com.alcadiosystem.examplemvvm.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.randomQuote()

        quoteViewModel.quoteModel.observe(this){ currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        }

        quoteViewModel.isLoading.observe(this, Observer {2
            binding.progressIndicator.isVisible = it
        })

        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }

    }
}