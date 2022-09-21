package com.lemonhead.testwork.ui.appactivity

import moxy.MvpPresenter

class AppPresenter : MvpPresenter<AppView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.onFirstOpen()
    }

    companion object {
        private const val TAG = "AppPresenter"
    }
}