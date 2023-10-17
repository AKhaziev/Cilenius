package com.example.cilenius.di

import com.example.cilenius.presention.CoinViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<CoinViewModel> {
        CoinViewModel(
            getCoinInfoListUseCase = get(),
            getCoinInfoUseCase = get(),
            loadDataUseCase = get()
        )
    }
}
