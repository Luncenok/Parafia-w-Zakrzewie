/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 6:58 PM
 *
 */

package pl.godziszewo.kosciol.kosciolui.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.godziszewo.kosciol.data.ChurchRepositoryImp
import pl.godziszewo.kosciol.domain.repository.ChurchRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideCharacterRepository(churchRepository: ChurchRepositoryImp): ChurchRepository =
        churchRepository
}
