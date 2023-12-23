/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 12/23/23, 2:16 PM
 *
 */

package pl.godziszewo.kosciol.data.repository

import pl.godziszewo.kosciol.data.models.AnnouncementEntity
import pl.godziszewo.kosciol.data.models.CemeteryEntity
import pl.godziszewo.kosciol.data.models.ConfessionEntity
import pl.godziszewo.kosciol.data.models.ContactEntity
import pl.godziszewo.kosciol.data.models.HistoryEntity
import pl.godziszewo.kosciol.data.models.IntentionEntity
import pl.godziszewo.kosciol.data.models.MassesEntity
import pl.godziszewo.kosciol.data.models.NewsEntity

interface ChurchCache {
    suspend fun getNews(): List<NewsEntity>
    suspend fun saveNews(listNews: List<NewsEntity>)
    suspend fun getAnnouncements(): AnnouncementEntity
    suspend fun saveAnnouncements(announcements: AnnouncementEntity)
    suspend fun getIntentions(): IntentionEntity
    suspend fun saveIntentions(intentions: IntentionEntity)
    suspend fun getCemetery(): CemeteryEntity
    suspend fun saveCemetery(cemetery: CemeteryEntity)
    suspend fun getContact(): ContactEntity
    suspend fun saveContact(contact: ContactEntity)
    suspend fun getConfession(): ConfessionEntity
    suspend fun saveConfession(confession: ConfessionEntity)
    suspend fun getHistory(): HistoryEntity
    suspend fun saveHistory(history: HistoryEntity)
    suspend fun getMasses(): MassesEntity
    suspend fun saveMasses(masses: MassesEntity)
    suspend fun isNewsCached(): Boolean
    suspend fun isAnnouncementsCached(): Boolean
    suspend fun isIntentionsCached(): Boolean
    suspend fun isCemeteryCached(): Boolean
    suspend fun isContactCached(): Boolean
    suspend fun isConfessionCached(): Boolean
    suspend fun isHistoryCached(): Boolean
    suspend fun isMassesCached(): Boolean
    suspend fun setNewsLastCacheTime(lastCache: Long)
    suspend fun setAnnouncementsLastCacheTime(lastCache: Long)
    suspend fun setIntentionsLastCacheTime(lastCache: Long)
    suspend fun setCemeteryLastCacheTime(lastCache: Long)
    suspend fun setContactLastCacheTime(lastCache: Long)
    suspend fun setConfessionLastCacheTime(lastCache: Long)
    suspend fun setHistoryLastCacheTime(lastCache: Long)
    suspend fun setMassesLastCacheTime(lastCache: Long)
    suspend fun isNewsExpired(): Boolean
    suspend fun isAnnouncementsExpired(): Boolean
    suspend fun isIntentionsExpired(): Boolean
    suspend fun isCemeteryExpired(): Boolean
    suspend fun isContactExpired(): Boolean
    suspend fun isConfessionExpired(): Boolean
    suspend fun isHistoryExpired(): Boolean
    suspend fun isMassesExpired(): Boolean
    suspend fun setFirstUse()
    suspend fun getFirstUse(): Boolean
}