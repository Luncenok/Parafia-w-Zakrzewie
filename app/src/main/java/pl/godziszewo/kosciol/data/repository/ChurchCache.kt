/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 5/8/23, 8:09 PM
 *
 */

package pl.godziszewo.kosciol.data.repository

import pl.godziszewo.kosciol.data.models.NewsEntity
import pl.godziszewo.kosciol.data.models.AnnouncementEntity

interface ChurchCache {
    suspend fun getNews(): List<NewsEntity>
    suspend fun getOgloszenia(): List<AnnouncementEntity>
    suspend fun saveNews(listAktualnosci: List<NewsEntity>)
    suspend fun saveOgloszenia(listOgloszenia: List<AnnouncementEntity>)
    suspend fun isCached(): Boolean
    suspend fun setLastCacheTime(lastCache: Long)
    suspend fun isExpired(): Boolean
    suspend fun setFirstUse()
    suspend fun getFirstUse(): Boolean
}