package com.lemonhead.testwork.ui.splash

import com.lemonhead.testwork.model.ErrorViewModel
import moxy.MvpView

interface SplashView : MvpView {
    fun onOpenMapScreen()
    fun onShowDialog(error: ErrorViewModel)
}