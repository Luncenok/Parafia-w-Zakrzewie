/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 6:18 PM
 *
 */

package pl.godziszewo.kosciol.cache

import pl.godziszewo.kosciol.cache.dao.ChurchDao
import pl.godziszewo.kosciol.cache.mapper.NewsCacheMapper
import pl.godziszewo.kosciol.cache.utils.CachePreferencesHelper
import pl.godziszewo.kosciol.data.models.AnnouncementEntity
import pl.godziszewo.kosciol.data.models.NewsEntity
import pl.godziszewo.kosciol.data.repository.ChurchCache
import javax.inject.Inject

class ChurchCacheImp @Inject constructor(
    private val churchDao: ChurchDao,
    private val newsCacheMapper: NewsCacheMapper,
    private val preferencesHelper: CachePreferencesHelper
) : ChurchCache {
    override suspend fun getNews(): List<NewsEntity> {
        return churchDao.getAllNews().map { cacheNews ->
            newsCacheMapper.mapFromCached(cacheNews)
        }
    }

    override suspend fun getOgloszenia(): List<AnnouncementEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(listAktualnosci: List<NewsEntity>) {
        churchDao.addNews(
            *listAktualnosci.map { newsEntity ->
                newsCacheMapper.mapToCached(newsEntity)
            }.toTypedArray()
        )
    }

    override suspend fun saveOgloszenia(listOgloszenia: List<AnnouncementEntity>) {
        TODO("Not yet implemented")
    }

    override suspend fun isCached(): Boolean {
        return churchDao.getAllNews().isNotEmpty()
    }

    override suspend fun setLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheTime = lastCache
    }

    override suspend fun setFirstUse() {
        preferencesHelper.isFirstUse = true
    }

    override suspend fun getFirstUse(): Boolean {
        return preferencesHelper.isFirstUse
    }

    override suspend fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = getLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    /**
     * Get in millis, the last time the cache was accessed.
     */
    private fun getLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCacheTime
    }

    companion object {
        /**
         * Expiration time set to 15 minutes
         */
        const val EXPIRATION_TIME = (1000 * 60 * 15).toLong()
    }
}