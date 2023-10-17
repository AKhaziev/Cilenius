package com.example.cilenius.di

import androidx.room.Room
import com.example.cilenius.data.database.AppDatabase
import com.example.cilenius.data.database.CoinInfoDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

private const val DB_NAME = "main_db"

val roomModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            DB_NAME
        ).build()
    }

    single<CoinInfoDao> {
        val database = get<AppDatabase>()
        database.coinPriceInfoDao()
    }
}

