package com.lemonhead.testwork

import android.app.Application
import com.lemonhead.testwork.di.DIManager
import com.lemonhead.testwork.di.component.DaggerApplicationComponent
import com.yandex.mapkit.MapKitFactory

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DIManager.applicationComponent = DaggerApplicationComponent.builder()
            .setContext(this)
            .build()
        MapKitFactory.setApiKey("a714b277-85b9-434b-96d5-5b29a38985b9")
    }
}