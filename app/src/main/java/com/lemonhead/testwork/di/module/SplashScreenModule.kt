package com.lemonhead.testwork.di.module

import com.lemonhead.domain.business.loading.port.IDataLoadService
import com.lemonhead.domain.business.mark.port.IMarkCache
import com.lemonhead.domain.business.mark.usecase.GetMarksFromDatabaseUseCase
import com.lemonhead.domain.business.mark.usecase.LoadAndSaveDataFromFileUseCase
import com.lemonhead.testwork.di.scope.screen.SplashScreenScope
import dagger.Module
import dagger.Provides

@Module
class SplashScreenModule {

    @SplashScreenScope
    @Provides
    fun provideGetMarksFromDatabaseUseCase(iMarkCache: IMarkCache): GetMarksFromDatabaseUseCase {
        return GetMarksFromDatabaseUseCase(iMarkCache)
    }

    @SplashScreenScope
    @Provides
    fun provideLoadAndSaveDataFromFileUseCase(
        dataLoadService: IDataLoadService,
        markCache: IMarkCache,
    ): LoadAndSaveDataFromFileUseCase {
        return LoadAndSaveDataFromFileUseCase(dataLoadService, markCache)
    }
}