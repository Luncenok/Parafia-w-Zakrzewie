/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 6/2/23, 4:23 PM
 *
 */

package com.aqube.ram.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pl.godziszewo.kosciol.cache.ChurchCacheImp
import pl.godziszewo.kosciol.cache.dao.ChurchDao
import pl.godziszewo.kosciol.cache.dao.GalleryDao
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
    fun provideChurchDao(churchDatabase: AppDatabase): ChurchDao {
        return churchDatabase.churchDao()
    }

    @Provides
    @Singleton
    fun provideGalleryDao(churchDatabase: AppDatabase): GalleryDao {
        return churchDatabase.galleryDao()
    }

    @Provides
    @Singleton
    fun provideChurchCache(churchCache: ChurchCacheImp): ChurchCache {
        return churchCache
    }

    @Provides
    @Singleton
    fun providePreferenceHelper(@ApplicationContext context: Context): CachePreferencesHelper {
        return CachePreferencesHelper(context)
    }
}
