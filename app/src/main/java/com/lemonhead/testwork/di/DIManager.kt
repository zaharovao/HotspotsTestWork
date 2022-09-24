package com.lemonhead.testwork.di

import com.lemonhead.testwork.di.component.ApplicationComponent
import com.lemonhead.testwork.di.component.SplashScreenSubcomponent
import com.lemonhead.testwork.di.module.SplashScreenModule

object DIManager {
    lateinit var applicationComponent: ApplicationComponent

    fun getSplashScreenSubcomponent(): SplashScreenSubcomponent {
        return applicationComponent.getSplashScreenSubcomponent(SplashScreenModule())
    }
}