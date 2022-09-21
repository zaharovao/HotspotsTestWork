package com.lemonhead.testwork.ui.splash

import android.content.Context
import com.lemonhead.testwork.R
import com.lemonhead.testwork.ui.appactivity.AppActivity
import com.lemonhead.testwork.utils.OnNavigateListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class SplashFragment : MvpAppCompatFragment(R.layout.fragment_splash), SplashView {

    private var onNavigateListener: OnNavigateListener? = null

    private val presenter by moxyPresenter { SplashPresenter() }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onNavigateListener = context as AppActivity
    }

    companion object {
        const val TAG = "SplashFragment"
    }
}