package com.lemonhead.testwork.ui.appactivity

import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.lemonhead.testwork.R
import com.lemonhead.testwork.di.DIManager
import com.lemonhead.testwork.di.component.DaggerApplicationComponent
import com.lemonhead.testwork.ui.splash.SplashFragment
import com.lemonhead.testwork.utils.OnNavigateListener
import com.lemonhead.testwork.utils.attachFragment
import com.lemonhead.testwork.utils.replaceFragment
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class AppActivity : MvpAppCompatActivity(), AppView, OnNavigateListener {

    private lateinit var flAppContainer: FrameLayout

    private val presenter by moxyPresenter { AppPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        flAppContainer = findViewById(R.id.fl_app_container)
    }

    override fun onFirstOpen() {
        onNavigate(SplashFragment(), SplashFragment.TAG)
    }

    override fun onNavigate(fragmentInstance: Fragment, tag: String?, isAddToBackStack: Boolean) {
        supportFragmentManager.attachFragment(
            R.id.fl_app_container,
            fragmentInstance,
            tag,
            isAddToBackStack,
        )
    }

    override fun onNavigateExclusive(fragmentInstance: Fragment, tag: String?) {
        supportFragmentManager.replaceFragment(
            R.id.fl_app_container,
            fragmentInstance,
            tag,
        )
    }
}