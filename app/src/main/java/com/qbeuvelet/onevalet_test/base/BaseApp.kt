package com.qbeuvelet.onevalet_test.base

import android.app.Application
import com.qbeuvelet.onevalet_test.di.AppModule
import com.qbeuvelet.onevalet_test.di.ApplicationComponent
import com.qbeuvelet.onevalet_test.di.DaggerApplicationComponent

class BaseApp: Application() {
    companion object {
        lateinit var instance: BaseApp
        lateinit var appComponent: ApplicationComponent
    }

    private fun initializeDagger() {
        appComponent = DaggerApplicationComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
        instance = this
    }
}