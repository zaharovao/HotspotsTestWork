package com.lemonhead.testwork.di.component

import com.lemonhead.testwork.di.module.SplashScreenModule
import com.lemonhead.testwork.di.scope.screen.SplashScreenScope
import com.lemonhead.testwork.ui.splash.SplashPresenter
import dagger.Subcomponent

@SplashScreenScope
@Subcomponent(modules = [SplashScreenModule::class])
interface SplashScreenSubcomponent {
    fun inject(presenter: SplashPresenter)
}