package com.example.cilenius.app

import android.app.Application
import com.example.cilenius.di.appModule
import com.example.cilenius.di.dataModule
import com.example.cilenius.di.domainModule
import com.example.cilenius.di.retrofitModule
import com.example.cilenius.di.roomModule
import com.example.cilenius.di.workerModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            workManagerFactory()
            modules(listOf(
                appModule,
                dataModule,
                domainModule,
                roomModule,
                workerModule,
                retrofitModule
            ))
        }
    }
}