package com.example.cilenius.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CoinInfoDbModel::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun coinPriceInfoDao(): CoinInfoDao
}