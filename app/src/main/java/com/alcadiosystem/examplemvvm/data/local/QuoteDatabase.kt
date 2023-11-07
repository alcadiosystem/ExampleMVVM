package com.alcadiosystem.examplemvvm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alcadiosystem.examplemvvm.data.local.DAO.QuoteDao
import com.alcadiosystem.examplemvvm.data.local.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao
}