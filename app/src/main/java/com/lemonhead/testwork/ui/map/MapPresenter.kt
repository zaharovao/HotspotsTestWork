package com.lemonhead.testwork.ui.map

import android.util.Log
import com.lemonhead.domain.business.mark.usecase.GetMarksFromDatabaseUseCase
import com.lemonhead.testwork.di.DIManager
import com.lemonhead.testwork.model.MarkViewModel
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class MapPresenter : MvpPresenter<MapView>() {

    @Inject
    lateinit var getMarksFromDatabaseUseCase: GetMarksFromDatabaseUseCase

    private val markViewModelMapper = MarkViewModel.ViewModelMapper()

    init {
        DIManager.getMapScreenSubcomponent().inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadMarks()
    }

    private fun loadMarks() {
        presenterScope.launch {
            try {
                val markViewModelList = getMarksFromDatabaseUseCase.execute().map {
                    markViewModelMapper.mapFromEntity(it)
                }
//                viewState.onShowMarks(markViewModelList)
            } catch (e: Exception) {
                Log.e(TAG, e.message, e)
                // TODO("Handle exceptions")
            }
        }
    }

    companion object {
        private const val TAG = "MapPresenter"
    }
}