package com.example.cilenius.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.cilenius.data.database.CoinInfoDao
import com.example.cilenius.data.mapper.CoinMapper
import com.example.cilenius.data.workers.RefreshDataWorker
import com.example.cilenius.domain.CoinInfo
import com.example.cilenius.domain.CoinRepository
import org.koin.core.component.KoinComponent

class CoinRepositoryImpl(
    private val coinInfoDao: CoinInfoDao,
    private val mapper: CoinMapper,
    private val workManager: WorkManager,

    ) : CoinRepository, KoinComponent {
    override fun getCoinInfoList(): LiveData<List<CoinInfo>> {
        return coinInfoDao.getPriceList().map {
            it.map {
                mapper.mapDbModelToEntity(it)
            }
        }
    }

    override fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo> {
        return coinInfoDao.getPriceInfoAboutCoin(fromSymbol).map {
            mapper.mapDbModelToEntity(it)
        }
    }

    override fun loadData() {

//        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshDataWorker.NAME, ExistingWorkPolicy.REPLACE, RefreshDataWorker.makeRequest()
        )
    }
}