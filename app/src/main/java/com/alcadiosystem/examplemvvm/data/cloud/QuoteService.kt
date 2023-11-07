package com.alcadiosystem.examplemvvm.data.cloud

import com.alcadiosystem.examplemvvm.core.RetrofitHelper
import com.alcadiosystem.examplemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(
    private val api:QuoteApiClient
){

    suspend fun getQuote():List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = api.getAllQuotes()
            response.body()?: emptyList()
        }
    }

}