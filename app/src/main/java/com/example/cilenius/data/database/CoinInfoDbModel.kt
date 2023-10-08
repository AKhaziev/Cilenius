package com.example.cilenius.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "full_price_list")
data class CoinInfoDbModel (
    @PrimaryKey
    val fromSymbol: String,
    val toSymbol: String? = null,
    val lastMarket: String? = null,
    val price: Double? = null,
    val lastUpdate: Long? = null,
    val highDay: Double? = null,
    val lowDay: Double? = null,
    val imageUrl: String
)