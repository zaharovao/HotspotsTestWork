package com.lemonhead.testwork.ui.appactivity

import moxy.MvpView

interface AppView : MvpView {
    fun onFirstOpen()
}