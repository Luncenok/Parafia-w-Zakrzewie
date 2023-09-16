/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/16/23, 5:00 PM
 *
 */

package pl.godziszewo.kosciol.data.source

import pl.godziszewo.kosciol.data.models.AnnouncementEntity
import pl.godziszewo.kosciol.data.models.CemeteryEntity
import pl.godziszewo.kosciol.data.models.ConfessionEntity
import pl.godziszewo.kosciol.data.models.ContactEntity
import pl.godziszewo.kosciol.data.models.HistoryEntity
import pl.godziszewo.kosciol.data.models.IntentionEntity
import pl.godziszewo.kosciol.data.models.MassesEntity
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

    override suspend fun getAnnouncements(): List<AnnouncementEntity> {
        return churchCache.getAnnouncements()
    }

    override suspend fun getIntentions(): List<IntentionEntity> {
        return churchCache.getIntentions()
    }

    override suspend fun getCemetery(): CemeteryEntity {
        return churchCache.getCemetery()
    }

    override suspend fun getContact(): ContactEntity {
        return churchCache.getContact()
    }

    override suspend fun getConfession(): ConfessionEntity {
        return churchCache.getConfession()
    }

    override suspend fun getHistory(): HistoryEntity {
        return churchCache.getHistory()
    }

    override suspend fun getMasses(): MassesEntity {
        return churchCache.getMasses()
    }

    override suspend fun saveNews(listNews: List<NewsEntity>) {
        churchCache.saveNews(listNews)
        churchCache.setNewsLastCacheTime(System.currentTimeMillis())
    }

    override suspend fun saveAnnouncements(listAnnouncements: List<AnnouncementEntity>) {
        churchCache.saveAnnouncements(listAnnouncements)
        churchCache.setAnnouncementsLastCacheTime(System.currentTimeMillis())
    }

    override suspend fun saveIntentions(listIntentions: List<IntentionEntity>) {
        churchCache.saveIntentions(listIntentions)
        churchCache.setIntentionsLastCacheTime(System.currentTimeMillis())
    }

    override suspend fun saveCemetery(cemetery: CemeteryEntity) {
        churchCache.saveCemetery(cemetery)
        churchCache.setCemeteryLastCacheTime(System.currentTimeMillis())
    }

    override suspend fun saveContact(contact: ContactEntity) {
        churchCache.saveContact(contact)
        churchCache.setContactLastCacheTime(System.currentTimeMillis())
    }

    override suspend fun saveConfession(confession: ConfessionEntity) {
        churchCache.saveConfession(confession)
        churchCache.setConfessionLastCacheTime(System.currentTimeMillis())
    }

    override suspend fun saveHistory(history: HistoryEntity) {
        churchCache.saveHistory(history)
        churchCache.setHistoryLastCacheTime(System.currentTimeMillis())
    }

    override suspend fun saveMasses(masses: MassesEntity) {
        churchCache.saveMasses(masses)
        churchCache.setMassesLastCacheTime(System.currentTimeMillis())
    }

    override suspend fun isNewsCached(): Boolean {
        return churchCache.isNewsCached()
    }

    override suspend fun isAnnouncementsCached(): Boolean {
        return churchCache.isAnnouncementsCached()
    }

    override suspend fun isIntentionsCached(): Boolean {
        return churchCache.isIntentionsCached()
    }

    override suspend fun isCemeteryCached(): Boolean {
        return churchCache.isCemeteryCached()
    }

    override suspend fun isContactCached(): Boolean {
        return churchCache.isContactCached()
    }

    override suspend fun isConfessionCached(): Boolean {
        return churchCache.isConfessionCached()
    }

    override suspend fun isHistoryCached(): Boolean {
        return churchCache.isHistoryCached()
    }

    override suspend fun isMassesCached(): Boolean {
        return churchCache.isMassesCached()
    }

}