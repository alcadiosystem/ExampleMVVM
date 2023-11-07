package com.alcadiosystem.examplemvvm.domain.model

import com.alcadiosystem.examplemvvm.data.local.entities.QuoteEntity
import com.alcadiosystem.examplemvvm.data.model.QuoteModel

data class Quote(
    val quote:String,
    val author:String
)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)