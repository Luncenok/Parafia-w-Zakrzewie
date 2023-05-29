/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 5/10/23, 9:57 PM
 *
 */

package pl.godziszewo.kosciol.data.source

import pl.godziszewo.kosciol.data.models.AnnouncementEntity
import pl.godziszewo.kosciol.data.models.NewsEntity
import pl.godziszewo.kosciol.data.repository.ChurchCache
import pl.godziszewo.kosciol.data.repository.ChurchDataSource
import javax.inject.Inject

class ChurchCacheDataSource @Inject constructor(
    private val churchCache: ChurchCache
) : ChurchDataSource {
    override suspend fun getNews(): List<NewsEntity> {
        return churchCache.getNews()
    }

    override suspend fun getOgloszenia(): List<AnnouncementEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(listAktualnosci: List<NewsEntity>) {
        churchCache.saveNews(listAktualnosci)
        churchCache.setLastCacheTime(System.currentTimeMillis())
    }

    override suspend fun saveOgloszenia(listOgloszenia: List<AnnouncementEntity>) {
        TODO("Not yet implemented")
    }

    override suspend fun isCached(): Boolean {
        return churchCache.isCached()
    }

}