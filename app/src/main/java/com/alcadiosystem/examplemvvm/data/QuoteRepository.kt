package com.alcadiosystem.examplemvvm.data

import com.alcadiosystem.examplemvvm.data.cloud.QuoteService
import com.alcadiosystem.examplemvvm.data.local.DAO.QuoteDao
import com.alcadiosystem.examplemvvm.data.local.entities.QuoteEntity
import com.alcadiosystem.examplemvvm.domain.model.Quote
import com.alcadiosystem.examplemvvm.domain.model.toDomain
import javax.inject.Inject


class QuoteRepository @Inject constructor(
    private val quoteService: QuoteService,
    private val quoteDao:QuoteDao
) {

    suspend fun getAllQuotes():List<Quote>{
        val response = quoteService.getQuote()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromLocal():List<Quote>{
        val response = quoteDao.getAllQuote()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }

}