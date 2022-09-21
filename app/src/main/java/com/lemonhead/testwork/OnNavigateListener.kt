package com.lemonhead.testwork

import androidx.fragment.app.Fragment

interface OnNavigateListener {
    fun onNavigate(fragmentInstance: Fragment, tag: String?, isAddToBackStack: Boolean = false)
    fun onNavigateExclusive(fragmentInstance: Fragment, tag: String?)
}