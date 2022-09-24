package com.lemonhead.testwork.di.component

import android.content.Context
import com.lemonhead.testwork.di.module.ApplicationModule
import com.lemonhead.testwork.di.module.SplashScreenModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApplicationModule::class]
)
interface ApplicationComponent {

    fun getSplashScreenSubcomponent(splashScreenModule: SplashScreenModule): SplashScreenSubcomponent

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun setContext(context: Context): Builder

        fun build(): ApplicationComponent
    }
}