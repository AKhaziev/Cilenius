package com.example.cilenius.di

import com.example.cilenius.domain.GetCoinInfoListUseCase
import com.example.cilenius.domain.GetCoinInfoUseCase
import com.example.cilenius.domain.LoadDataUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetCoinInfoListUseCase> {
        GetCoinInfoListUseCase(repository = get())
    }

    factory<GetCoinInfoUseCase> {
        GetCoinInfoUseCase(repository = get())
    }

    factory<LoadDataUseCase> {
        LoadDataUseCase(repository = get())
    }

}