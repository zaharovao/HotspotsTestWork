package com.lemonhead.testwork.utils

import android.util.Log
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun FragmentManager.attachFragment(
    @IdRes containerId: Int,
    fragmentInstance: Fragment,
    tag: String?,
    isAddToBackStack: Boolean = false
) {
    try {
        val fragmentTransaction = beginTransaction()

        var fragment = findFragmentByTag(tag)
        if (fragment == null) {
            fragment = fragmentInstance
            fragmentTransaction.add(containerId, fragment, tag)
        } else {
            fragmentTransaction.attach(fragment)
        }

        val curFrag = primaryNavigationFragment
        if (fragment != curFrag) {
            if (curFrag != null) {
                fragmentTransaction.detach(curFrag)
            }

            if (isAddToBackStack) {
                fragmentTransaction.addToBackStack(tag)
            }

            fragmentTransaction
                .setReorderingAllowed(true)
                .setPrimaryNavigationFragment(fragment)
                .commit()
        }
    } catch (e: Exception) {
        Log.d(tag, e.message, e)
    }
}

fun FragmentManager.replaceFragment(
    @IdRes containerId: Int,
    fragmentInstance: Fragment,
    tag: String?
) {
    try {
        val fragmentTransaction = beginTransaction()

        if (backStackEntryCount > 0) {
            popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }

        fragmentTransaction
            .replace(containerId, fragmentInstance, tag)
            .setReorderingAllowed(true)
            .setPrimaryNavigationFragment(fragmentInstance)
            .commit()
    } catch (e: Exception) {
        Log.d(tag, e.message, e)
    }
}

