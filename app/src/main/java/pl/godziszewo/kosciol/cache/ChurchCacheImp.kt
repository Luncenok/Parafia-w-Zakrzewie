/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 12/23/23, 2:19 PM
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

    override suspend fun getAnnouncements(): AnnouncementEntity {
        return churchDao.getAllAnnouncements().map { cacheAnnouncements ->
            announcementCacheMapper.mapFromCached(cacheAnnouncements)
        }.first()
    }

    override suspend fun saveAnnouncements(announcements: AnnouncementEntity) {
        churchDao.addAnnouncement(announcementCacheMapper.mapToCached(announcements))
    }

    override suspend fun getIntentions(): IntentionEntity {
        return churchDao.getAllIntentions().map { cacheIntentions ->
            intentionCacheMapper.mapFromCached(cacheIntentions)
        }.first()
    }

    override suspend fun saveIntentions(intentions: IntentionEntity) {
        churchDao.addIntention(intentionCacheMapper.mapToCached(intentions))
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


    override suspend fun setNewsLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheTimeNews = lastCache
    }

    override suspend fun setAnnouncementsLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheTimeAnnouncements = lastCache
    }

    override suspend fun setIntentionsLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheTimeIntentions = lastCache
    }

    override suspend fun setCemeteryLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheTimeCemetery = lastCache
    }

    override suspend fun setContactLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheTimeContact = lastCache
    }

    override suspend fun setConfessionLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheTimeConfession = lastCache
    }

    override suspend fun setHistoryLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheTimeHistory = lastCache
    }

    override suspend fun setMassesLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheTimeMasses = lastCache
    }

    override suspend fun setFirstUse() {
        preferencesHelper.isFirstUse = true
    }

    override suspend fun getFirstUse(): Boolean {
        return preferencesHelper.isFirstUse
    }

    override suspend fun isNewsExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = getNewsLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    override suspend fun isAnnouncementsExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = getAnnouncementsLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    override suspend fun isIntentionsExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = getIntentionsLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    override suspend fun isCemeteryExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = getCemeteryLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    override suspend fun isContactExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = getContactLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    override suspend fun isConfessionExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = getConfessionLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    override suspend fun isHistoryExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = getHistoryLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    override suspend fun isMassesExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = getMassesLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    /**
     * Get in millis, the last time the cache was accessed.
     */
    private fun getNewsLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCacheTimeNews
    }

    private fun getAnnouncementsLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCacheTimeAnnouncements
    }

    private fun getIntentionsLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCacheTimeIntentions
    }

    private fun getCemeteryLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCacheTimeCemetery
    }

    private fun getContactLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCacheTimeContact
    }

    private fun getConfessionLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCacheTimeConfession
    }

    private fun getHistoryLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCacheTimeHistory
    }

    private fun getMassesLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCacheTimeMasses
    }

    companion object {
        /**
         * Expiration time set to 1 second
         */
        const val EXPIRATION_TIME = (1000).toLong()
    }
}