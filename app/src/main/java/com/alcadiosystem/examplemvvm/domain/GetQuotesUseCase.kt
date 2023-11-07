package com.alcadiosystem.examplemvvm.domain

import com.alcadiosystem.examplemvvm.data.QuoteRepository
import com.alcadiosystem.examplemvvm.data.local.entities.toDataBase
import com.alcadiosystem.examplemvvm.data.model.QuoteModel
import com.alcadiosystem.examplemvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository:QuoteRepository
) {


    suspend operator fun invoke(): List<Quote> {
        val quote = repository.getAllQuotes()
        return if(quote.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quote.map { it.toDataBase() })
            quote
        }else{
            repository.getAllQuotesFromLocal()
        }
    }
}