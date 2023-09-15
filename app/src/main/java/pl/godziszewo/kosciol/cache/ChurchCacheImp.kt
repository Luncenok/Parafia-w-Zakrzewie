/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/16/23, 12:10 AM
 *
 */

package pl.godziszewo.kosciol.cache

import pl.godziszewo.kosciol.cache.dao.ChurchDao
import pl.godziszewo.kosciol.cache.mapper.AnnouncementCacheMapper
import pl.godziszewo.kosciol.cache.mapper.CemeteryCacheMapper
import pl.godziszewo.kosciol.cache.mapper.ConfessionCacheMapper
import pl.godziszewo.kosciol.cache.mapper.ContactCacheMapper
import pl.godziszewo.kosciol.cache.mapper.HistoryCacheMapper
import pl.godziszewo.kosciol.cache.mapper.IntentionCacheMapper
import pl.godziszewo.kosciol.cache.mapper.MassesCacheMapper
import pl.godziszewo.kosciol.cache.mapper.NewsCacheMapper
import pl.godziszewo.kosciol.cache.utils.CachePreferencesHelper
import pl.godziszewo.kosciol.data.models.AnnouncementEntity
import pl.godziszewo.kosciol.data.models.CemeteryEntity
import pl.godziszewo.kosciol.data.models.ConfessionEntity
import pl.godziszewo.kosciol.data.models.ContactEntity
import pl.godziszewo.kosciol.data.models.HistoryEntity
import pl.godziszewo.kosciol.data.models.IntentionEntity
import pl.godziszewo.kosciol.data.models.MassesEntity
import pl.godziszewo.kosciol.data.models.NewsEntity
import pl.godziszewo.kosciol.data.repository.ChurchCache
import javax.inject.Inject

class ChurchCacheImp @Inject constructor(
    private val churchDao: ChurchDao,
    private val newsCacheMapper: NewsCacheMapper,
    private val announcementCacheMapper: AnnouncementCacheMapper,
    private val cemeteryCacheMapper: CemeteryCacheMapper,
    private val confessionCacheMapper: ConfessionCacheMapper,
    private val contactCacheMapper: ContactCacheMapper,
    private val historyCacheMapper: HistoryCacheMapper,
    private val intentionCacheMapper: IntentionCacheMapper,
    private val massesCacheMapper: MassesCacheMapper,
    private val preferencesHelper: CachePreferencesHelper
) : ChurchCache {
    override suspend fun getNews(): List<NewsEntity> {
        return churchDao.getAllNews().map { cacheNews ->
            newsCacheMapper.mapFromCached(cacheNews)
        }
    }

    override suspend fun saveNews(listNews: List<NewsEntity>) {
        churchDao.addNews(
            *listNews.map { newsEntity ->
                newsCacheMapper.mapToCached(newsEntity)
            }.toTypedArray()
        )
    }

    override suspend fun getAnnouncements(): List<AnnouncementEntity> {
        return churchDao.getAllAnnouncements().map { cacheAnnouncements ->
            announcementCacheMapper.mapFromCached(cacheAnnouncements)
        }
    }

    override suspend fun saveAnnouncements(listAnnouncements: List<AnnouncementEntity>) {
        churchDao.addAnnouncement(
            *listAnnouncements.map { announcementEntity ->
                announcementCacheMapper.mapToCached(announcementEntity)
            }.toTypedArray()
        )
    }

    override suspend fun getIntentions(): List<IntentionEntity> {
        return churchDao.getAllIntentions().map { cacheIntentions ->
            intentionCacheMapper.mapFromCached(cacheIntentions)
        }
    }

    override suspend fun saveIntentions(listIntentions: List<IntentionEntity>) {
        churchDao.addIntention(
            *listIntentions.map { intentionEntity ->
                intentionCacheMapper.mapToCached(intentionEntity)
            }.toTypedArray()
        )
    }

    override suspend fun getCemetery(): CemeteryEntity {
        return cemeteryCacheMapper.mapFromCached(churchDao.getCemetery()!!)
    }

    override suspend fun saveCemetery(cemetery: CemeteryEntity) {
        churchDao.addCemetery(cemeteryCacheMapper.mapToCached(cemetery))
    }

    override suspend fun getContact(): ContactEntity {
        return contactCacheMapper.mapFromCached(churchDao.getContact()!!)
    }

    override suspend fun saveContact(contact: ContactEntity) {
        churchDao.addContact(contactCacheMapper.mapToCached(contact))
    }

    override suspend fun getConfession(): ConfessionEntity {
        return confessionCacheMapper.mapFromCached(churchDao.getConfessions()!!)
    }

    override suspend fun saveConfession(confession: ConfessionEntity) {
        churchDao.addConfessions(confessionCacheMapper.mapToCached(confession))
    }

    override suspend fun getHistory(): HistoryEntity {
        return historyCacheMapper.mapFromCached(churchDao.getHistory()!!)
    }

    override suspend fun saveHistory(history: HistoryEntity) {
        churchDao.addHistory(historyCacheMapper.mapToCached(history))
    }

    override suspend fun getMasses(): MassesEntity {
        return massesCacheMapper.mapFromCached(churchDao.getMasses()!!)
    }

    override suspend fun saveMasses(masses: MassesEntity) {
        churchDao.addMasses(massesCacheMapper.mapToCached(masses))
    }


    override suspend fun isNewsCached(): Boolean {
        return churchDao.getAllNews().isNotEmpty()
    }

    override suspend fun isAnnouncementsCached(): Boolean {
        return churchDao.getAllAnnouncements().isNotEmpty()
    }

    override suspend fun isIntentionsCached(): Boolean {
        return churchDao.getAllIntentions().isNotEmpty()
    }

    override suspend fun isCemeteryCached(): Boolean {
        return churchDao.getCemetery() != null
    }

    override suspend fun isContactCached(): Boolean {
        return churchDao.getContact() != null
    }

    override suspend fun isConfessionCached(): Boolean {
        return churchDao.getConfessions() != null
    }

    override suspend fun isHistoryCached(): Boolean {
        return churchDao.getHistory() != null
    }

    override suspend fun isMassesCached(): Boolean {
        return churchDao.getMasses() != null
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