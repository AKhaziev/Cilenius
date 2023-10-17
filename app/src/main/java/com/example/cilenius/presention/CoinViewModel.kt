package com.example.cilenius.presention

import androidx.lifecycle.ViewModel
import com.example.cilenius.domain.GetCoinInfoListUseCase
import com.example.cilenius.domain.GetCoinInfoUseCase
import com.example.cilenius.domain.LoadDataUseCase

class CoinViewModel(
    private val getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    private val loadDataUseCase: LoadDataUseCase
) : ViewModel() {


//    private val repository = CoinRepositoryImpl(application)


    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }

}