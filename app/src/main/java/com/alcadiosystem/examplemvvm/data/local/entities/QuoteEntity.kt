package com.alcadiosystem.examplemvvm.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alcadiosystem.examplemvvm.domain.model.Quote

@Entity(tableName = "quote_table")
data class QuoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int = 0,
    @ColumnInfo(name = "quote") val quote:String,
    @ColumnInfo(name = "author") val author:String
)

fun Quote.toDataBase() = QuoteEntity(quote = quote, author = author)