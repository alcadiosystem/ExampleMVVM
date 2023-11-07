package com.alcadiosystem.examplemvvm.data.cloud

import com.alcadiosystem.examplemvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {

    @GET(".json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>

}