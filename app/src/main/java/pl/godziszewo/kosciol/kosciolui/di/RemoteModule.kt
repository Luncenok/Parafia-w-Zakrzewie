package com.aqube.ram.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.godziszewo.kosciol.BuildConfig
import pl.godziszewo.kosciol.data.repository.ChurchRemote
import pl.godziszewo.kosciol.remote.api.ChurchService
import pl.godziszewo.kosciol.remote.api.ServiceFactory
import pl.godziszewo.kosciol.remote.repository.ChurchRemoteImp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideChurchService(): ChurchService {
        return ServiceFactory.create(BuildConfig.DEBUG, BuildConfig.BASE_URL)
    }

    @Provides
    @Singleton
    fun provideChurchRemote(churchRemote: ChurchRemoteImp): ChurchRemote {
        return churchRemote
    }
}
