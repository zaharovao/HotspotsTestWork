package com.lemonhead.testwork.ui.map

import com.lemonhead.testwork.model.MarkViewModel
import moxy.MvpView

interface MapView : MvpView {
    fun onShowMarks(marks: List<MarkViewModel>)
}