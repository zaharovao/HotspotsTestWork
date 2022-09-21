package com.lemonhead.testwork.ui.splash

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.lemonhead.testwork.MainActivity
import com.lemonhead.testwork.OnNavigateListener
import com.lemonhead.testwork.R

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private var onNavigateListener: OnNavigateListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onNavigateListener = context as MainActivity
    }

    companion object {
        const val TAG = "SplashFragment"
    }
}