/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 11:10 PM
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

interface ChurchDataSource {
    // Remote and cache
    suspend fun getNews(): List<NewsEntity>
    suspend fun getAnnouncements(): List<AnnouncementEntity>
    suspend fun getIntentions(): List<IntentionEntity>
    suspend fun getCemetery(): CemeteryEntity
    suspend fun getContact(): ContactEntity
    suspend fun getConfession(): ConfessionEntity
    suspend fun getHistory(): HistoryEntity
    suspend fun getMasses(): MassesEntity

    // Cache
    suspend fun saveNews(listNews: List<NewsEntity>)
    suspend fun saveAnnouncements(listAnnouncements: List<AnnouncementEntity>)
    suspend fun saveIntentions(listIntentions: List<IntentionEntity>)
    suspend fun saveCemetery(cemetery: CemeteryEntity)
    suspend fun saveContact(contact: ContactEntity)
    suspend fun saveConfession(confession: ConfessionEntity)
    suspend fun saveHistory(history: HistoryEntity)
    suspend fun saveMasses(masses: MassesEntity)
    suspend fun isNewsCached(): Boolean
    suspend fun isAnnouncementsCached(): Boolean
    suspend fun isIntentionsCached(): Boolean
    suspend fun isCemeteryCached(): Boolean
    suspend fun isContactCached(): Boolean
    suspend fun isConfessionCached(): Boolean
    suspend fun isHistoryCached(): Boolean
    suspend fun isMassesCached(): Boolean
}