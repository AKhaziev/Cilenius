package com.example.cilenius.di

import androidx.work.WorkManager
import com.example.cilenius.data.workers.RefreshDataWorker
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.dsl.worker
import org.koin.dsl.module

val workerModule = module {
    factory<WorkManager> { WorkManager.getInstance(get()) }
    worker { RefreshDataWorker(androidContext(), get())  }


}