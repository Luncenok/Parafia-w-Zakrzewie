/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/4/23, 8:05 PM
 *
 */

package pl.godziszewo.kosciol.data.repository

import pl.godziszewo.kosciol.data.models.NewsEntity
import pl.godziszewo.kosciol.data.models.AnnouncementEntity

interface ChurchDataSource {
    // Remote and cache
    suspend fun getNews(): List<NewsEntity>
    suspend fun getOgloszenia(): List<AnnouncementEntity>

    // Cache
    suspend fun saveNews(listAktualnosci: List<NewsEntity>)
    suspend fun saveOgloszenia(listOgloszenia: List<AnnouncementEntity>)
    suspend fun isCached(): Boolean
}