package com.example.cilenius.presention

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.cilenius.data.repository.CoinRepositoryImpl
import com.example.cilenius.domain.GetCoinInfoListUseCase
import com.example.cilenius.domain.GetCoinInfoUseCase
import com.example.cilenius.domain.LoadDataUseCase

class CoinViewModel(application: Application) : ViewModel() {


    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }

}