package com.lemonhead.testwork.ui.splash

import android.util.Log
import com.lemonhead.domain.business.mark.usecase.GetMarksFromDatabaseUseCase
import com.lemonhead.domain.business.mark.usecase.LoadAndSaveDataFromFileUseCase
import com.lemonhead.testwork.di.DIManager
import com.lemonhead.testwork.model.ErrorViewModel
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class SplashPresenter : MvpPresenter<SplashView>() {

    @Inject
    lateinit var getMarksFromDatabaseUseCase: GetMarksFromDatabaseUseCase

    @Inject
    lateinit var loadAndSaveDataFromFileUseCase: LoadAndSaveDataFromFileUseCase

    init {
        DIManager.getSplashScreenSubcomponent().inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getMarks()
    }

    fun loadFromFile(path: String) {
        presenterScope.launch {
            try {
                loadAndSaveDataFromFileUseCase.execute(path)
                viewState.onOpenMapScreen()
            } catch (e: Exception) {
                Log.e(TAG, e.message, e)
                viewState.onShowDialog(ErrorViewModel.fromException(e))
            }
        }
    }

    private fun getMarks() {
        presenterScope.launch {
            try {
                getMarksFromDatabaseUseCase.execute()
                viewState.onOpenMapScreen()
            } catch (e: Exception) {
                Log.e(TAG, e.message, e)
                viewState.onShowDialog(ErrorViewModel.fromException(e))
            }
        }
    }

    companion object {
        const val TAG = "SplashPresenter"
    }
}