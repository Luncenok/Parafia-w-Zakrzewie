/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/4/23, 8:05 PM
 *
 */

package pl.godziszewo.kosciol.kosciolui.di

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.droidsonroids.retrofit2.JspoonConverterFactory
import pl.godziszewo.kosciol.cache.database.AppDatabase
import pl.godziszewo.kosciol.cache.dao.GalleryDao
import pl.godziszewo.kosciol.data.ChurchRepositoryImp
import pl.godziszewo.kosciol.data.GalleryInfoRepository
import pl.godziszewo.kosciol.data.repository.ChurchRemote
import pl.godziszewo.kosciol.domain.repository.ChurchRepository
import pl.godziszewo.kosciol.remote.api.ChurchService
import pl.godziszewo.kosciol.remote.repository.ChurchRemoteImp
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideCharacterRepository(churchRepository: ChurchRepositoryImp): ChurchRepository =
        churchRepository
}
