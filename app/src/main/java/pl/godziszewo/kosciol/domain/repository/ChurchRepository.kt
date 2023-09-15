/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
 *
 */

package pl.godziszewo.kosciol.domain.repository

import kotlinx.coroutines.flow.Flow
import pl.godziszewo.kosciol.domain.models.Announcement
import pl.godziszewo.kosciol.domain.models.Cemetery
import pl.godziszewo.kosciol.domain.models.Confession
import pl.godziszewo.kosciol.domain.models.Contact
import pl.godziszewo.kosciol.domain.models.History
import pl.godziszewo.kosciol.domain.models.Intention
import pl.godziszewo.kosciol.domain.models.Masses
import pl.godziszewo.kosciol.domain.models.News

interface ChurchRepository {
    // Remote and cache
    suspend fun getNews(): Flow<List<News>>
    suspend fun getAnnouncements(): Flow<List<Announcement>>
    suspend fun getIntentions(): Flow<List<Intention>>
    suspend fun getCemetery(): Flow<Cemetery>
    suspend fun getContact(): Flow<Contact>
    suspend fun getConfession(): Flow<Confession>
    suspend fun getHistory(): Flow<History>
    suspend fun getMasses(): Flow<Masses>

    // Cache
    suspend fun saveNews(listNews: List<News>)
    suspend fun saveAnnouncements(listAnnouncement: List<Announcement>)
    suspend fun saveIntentions(listIntentions: List<Intention>)
    suspend fun saveCemetery(cemetery: Cemetery)
    suspend fun saveContact(contact: Contact)
    suspend fun saveConfession(confession: Confession)
    suspend fun saveHistory(history: History)
    suspend fun saveMasses(masses: Masses)
}