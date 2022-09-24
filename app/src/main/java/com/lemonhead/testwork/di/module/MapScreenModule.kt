package com.lemonhead.testwork.di.module

import com.lemonhead.domain.business.mark.port.IMarkCache
import com.lemonhead.domain.business.mark.usecase.GetMarksFromDatabaseUseCase
import com.lemonhead.testwork.di.scope.screen.MapScreenScope
import dagger.Module
import dagger.Provides

@Module
class MapScreenModule {
    @MapScreenScope
    @Provides
    fun provideGetMarksFromDatabaseUseCase(iMarkCache: IMarkCache): GetMarksFromDatabaseUseCase {
        return GetMarksFromDatabaseUseCase(iMarkCache)
    }
}