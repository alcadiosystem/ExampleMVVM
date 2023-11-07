package com.alcadiosystem.examplemvvm.domain

import com.alcadiosystem.examplemvvm.data.QuoteRepository
import com.alcadiosystem.examplemvvm.data.model.QuoteModel
import com.alcadiosystem.examplemvvm.domain.model.Quote
import javax.inject.Inject


class GetRandomQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository
){

    suspend operator fun invoke(): Quote?{
        val quotes = repository.getAllQuotesFromLocal()
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}