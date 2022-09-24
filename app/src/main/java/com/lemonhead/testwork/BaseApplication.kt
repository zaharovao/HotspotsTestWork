package com.lemonhead.testwork

import android.app.Application
import com.lemonhead.testwork.di.DIManager
import com.lemonhead.testwork.di.component.DaggerApplicationComponent

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DIManager.applicationComponent = DaggerApplicationComponent.builder()
            .setContext(this)
            .build()
    }
}