package com.goth4m.tiki

import android.app.Application
import com.goth4m.tiki.di.module.networkModule
import com.goth4m.tiki.di.module.repositoryModule
import com.goth4m.tiki.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by TuanTM on 7/30/20.
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            // declare used Android context
            androidContext(this@MyApplication)
            // declare modules
            modules(networkModule, repositoryModule, viewModelModule)
        }
    }
}