package com.github.tehras.valorantstats

import android.app.Application
import com.github.tehras.valorantstats.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class WorkflowApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WorkflowApp)
            androidLogger(Level.DEBUG)
            modules(appModule)
        }
    }
}