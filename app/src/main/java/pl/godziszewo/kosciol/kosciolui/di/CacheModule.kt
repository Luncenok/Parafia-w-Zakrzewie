package com.aqube.ram.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pl.godziszewo.kosciol.cache.ChurchCacheImp
import pl.godziszewo.kosciol.cache.dao.ChurchDao
import pl.godziszewo.kosciol.cache.database.AppDatabase
import pl.godziszewo.kosciol.cache.utils.CachePreferencesHelper
import pl.godziszewo.kosciol.data.repository.ChurchCache
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideCharacterDao(churchDatabase: AppDatabase): ChurchDao {
        return churchDatabase.churchDao()
    }

    @Provides
    @Singleton
    fun provideCharacterCache(churchCache: ChurchCacheImp): ChurchCache {
        return churchCache
    }

    @Provides
    @Singleton
    fun providePreferenceHelper(@ApplicationContext context: Context): CachePreferencesHelper {
        return CachePreferencesHelper(context)
    }
}
