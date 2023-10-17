package com.example.cilenius.di

import com.example.cilenius.data.mapper.CoinMapper
import com.example.cilenius.data.repository.CoinRepositoryImpl
import com.example.cilenius.domain.CoinRepository
import org.koin.dsl.module


val dataModule = module {

    factory<CoinMapper> {
        CoinMapper()
    }

    single<CoinRepository> {
        CoinRepositoryImpl(application = get(), coinInfoDao = get(), mapper = get())
    }

}