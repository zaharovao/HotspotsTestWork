package com.lemonhead.testwork.di.module

import com.lemonhead.domain.business.mark.port.IMarkCache
import com.lemonhead.domain.business.mark.usecase.GetMarksFromDatabaseUseCase
import com.lemonhead.testwork.di.scope.screen.SplashScreenScope
import dagger.Module
import dagger.Provides

@Module
class SplashScreenModule {

    @SplashScreenScope
    @Provides
    fun provideGetMarksFromDatabaseUseCase(markService: IMarkCache): GetMarksFromDatabaseUseCase {
        return GetMarksFromDatabaseUseCase(markService)
    }
}