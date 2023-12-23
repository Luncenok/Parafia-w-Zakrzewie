/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 12/23/23, 2:14 PM
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
import pl.godziszewo.kosciol.data.repository.ChurchDataSource
import pl.godziszewo.kosciol.data.repository.ChurchRemote
import javax.inject.Inject

class ChurchRemoteDataSource @Inject constructor(
    private val churchRemote: ChurchRemote
) : ChurchDataSource {
    override suspend fun getNews(): List<NewsEntity> {
        return churchRemote.getNews()
    }

    override suspend fun getAnnouncements(): AnnouncementEntity {
        return churchRemote.getAnnouncements()
    }

    override suspend fun getIntentions(): IntentionEntity {
        return churchRemote.getIntentions()
    }

    override suspend fun getCemetery(): CemeteryEntity {
        return churchRemote.getCemetery()
    }

    override suspend fun getContact(): ContactEntity {
        return churchRemote.getContact()
    }

    override suspend fun getConfession(): ConfessionEntity {
        return churchRemote.getConfession()
    }

    override suspend fun getHistory(): HistoryEntity {
        return churchRemote.getHistory()
    }

    override suspend fun getMasses(): MassesEntity {
        return churchRemote.getMasses()
    }

    override suspend fun saveNews(listNews: List<NewsEntity>) {
        throw UnsupportedOperationException("Save news is not supported for RemoteDataSource")
    }

    override suspend fun saveAnnouncements(announcements: AnnouncementEntity) {
        throw UnsupportedOperationException("Save announcement is not supported for RemoteDataSource")
    }

    override suspend fun saveIntentions(intentions: IntentionEntity) {
        throw UnsupportedOperationException("Save intention is not supported for RemoteDataSource")
    }

    override suspend fun saveCemetery(cemetery: CemeteryEntity) {
        throw UnsupportedOperationException("Save cemetery is not supported for RemoteDataSource")
    }

    override suspend fun saveContact(contact: ContactEntity) {
        throw UnsupportedOperationException("Save contact is not supported for RemoteDataSource")
    }

    override suspend fun saveConfession(confession: ConfessionEntity) {
        throw UnsupportedOperationException("Save confession is not supported for RemoteDataSource")
    }

    override suspend fun saveHistory(history: HistoryEntity) {
        throw UnsupportedOperationException("Save history is not supported for RemoteDataSource")
    }

    override suspend fun saveMasses(masses: MassesEntity) {
        throw UnsupportedOperationException("Save masses is not supported for RemoteDataSource")
    }

    override suspend fun isNewsCached(): Boolean {
        throw UnsupportedOperationException("Cache is not supported for RemoteDataSource.")
    }

    override suspend fun isAnnouncementsCached(): Boolean {
        throw UnsupportedOperationException("Cache is not supported for RemoteDataSource.")
    }

    override suspend fun isIntentionsCached(): Boolean {
        throw UnsupportedOperationException("Cache is not supported for RemoteDataSource.")
    }

    override suspend fun isCemeteryCached(): Boolean {
        throw UnsupportedOperationException("Cache is not supported for RemoteDataSource.")
    }

    override suspend fun isContactCached(): Boolean {
        throw UnsupportedOperationException("Cache is not supported for RemoteDataSource.")
    }

    override suspend fun isConfessionCached(): Boolean {
        throw UnsupportedOperationException("Cache is not supported for RemoteDataSource.")
    }

    override suspend fun isHistoryCached(): Boolean {
        throw UnsupportedOperationException("Cache is not supported for RemoteDataSource.")
    }

    override suspend fun isMassesCached(): Boolean {
        throw UnsupportedOperationException("Cache is not supported for RemoteDataSource.")
    }
}