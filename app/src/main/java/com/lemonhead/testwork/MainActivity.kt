package com.lemonhead.testwork

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.lemonhead.testwork.ui.splash.SplashFragment
import com.lemonhead.testwork.utils.attachFragment
import com.lemonhead.testwork.utils.replaceFragment

class MainActivity : AppCompatActivity(), OnNavigateListener {

    private lateinit var flMainContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flMainContainer = findViewById(R.id.fl_main_container)
    }

    override fun onNavigate(fragmentInstance: Fragment, tag: String?, isAddToBackStack: Boolean) {
        supportFragmentManager.attachFragment(
            R.id.fl_main_container,
            fragmentInstance,
            tag,
            isAddToBackStack,
        )
    }

    override fun onNavigateExclusive(fragmentInstance: Fragment, tag: String?) {
        supportFragmentManager.replaceFragment(
            R.id.fl_main_container,
            fragmentInstance,
            tag,
        )
    }


}