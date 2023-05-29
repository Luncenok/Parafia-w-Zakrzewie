/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/4/23, 9:50 PM
 *
 */

package pl.godziszewo.kosciol.domain.repository

import kotlinx.coroutines.flow.Flow
import pl.godziszewo.kosciol.data.models.AnnouncementEntity
import pl.godziszewo.kosciol.domain.models.News

interface ChurchRepository {
    // Remote and cache
    suspend fun getAktualnosci(): Flow<List<News>>
    suspend fun getOgloszenia(): Flow<List<AnnouncementEntity>>

    // Cache
    suspend fun saveAktualnosci(listAktualnosci: List<News>)
    suspend fun saveOgloszenia(listOgloszenia: List<AnnouncementEntity>)
}