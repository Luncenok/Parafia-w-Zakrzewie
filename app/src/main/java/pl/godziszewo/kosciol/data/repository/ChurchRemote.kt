/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 12/23/23, 2:05 PM
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

interface ChurchRemote {
    suspend fun getNews(): List<NewsEntity>
    suspend fun getAnnouncements(): AnnouncementEntity
    suspend fun getIntentions(): IntentionEntity
    suspend fun getCemetery(): CemeteryEntity
    suspend fun getContact(): ContactEntity
    suspend fun getConfession(): ConfessionEntity
    suspend fun getHistory(): HistoryEntity
    suspend fun getMasses(): MassesEntity
}