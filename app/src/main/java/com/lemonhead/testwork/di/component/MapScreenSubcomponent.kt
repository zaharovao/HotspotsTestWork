package com.lemonhead.testwork.di.component

import com.lemonhead.testwork.di.module.MapScreenModule
import com.lemonhead.testwork.di.scope.screen.MapScreenScope
import com.lemonhead.testwork.ui.map.MapPresenter
import dagger.Subcomponent

@MapScreenScope
@Subcomponent(modules = [MapScreenModule::class])
interface MapScreenSubcomponent {
    fun inject(presenter: MapPresenter)
}