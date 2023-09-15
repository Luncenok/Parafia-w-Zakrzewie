/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
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
    suspend fun getAnnouncements(): List<AnnouncementEntity>
    suspend fun saveAnnouncements(listAnnouncements: List<AnnouncementEntity>)
    suspend fun getIntentions(): List<IntentionEntity>
    suspend fun saveIntentions(listIntentions: List<IntentionEntity>)
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
    suspend fun isCached(): Boolean
    suspend fun setLastCacheTime(lastCache: Long)
    suspend fun isExpired(): Boolean
    suspend fun setFirstUse()
    suspend fun getFirstUse(): Boolean
}