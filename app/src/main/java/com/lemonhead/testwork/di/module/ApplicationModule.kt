package com.lemonhead.testwork.di.module

import android.content.Context
import com.lemonhead.database.port.MarkCacheImpl
import com.lemonhead.database.room.MainDatabase
import com.lemonhead.domain.business.loading.port.IDataLoadService
import com.lemonhead.domain.business.mark.port.IMarkCache
import com.lemonhead.testwork.service.DataLoadServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): MainDatabase {
        return MainDatabase.getDatabase(context)
    }

    @Singleton
    @Provides
    fun provideMarkService(database: MainDatabase): IMarkCache {
        return MarkCacheImpl(database.getMarkDao())
    }

    @Singleton
    @Provides
    fun provideDataLoadService(context: Context): IDataLoadService {
        return DataLoadServiceImpl(context)
    }
}