/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 12/23/23, 2:47 PM
 *
 */

package pl.godziszewo.kosciol.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pl.godziszewo.kosciol.data.mapper.AnnouncementsMapper
import pl.godziszewo.kosciol.data.mapper.CemeteryMapper
import pl.godziszewo.kosciol.data.mapper.ConfessionMapper
import pl.godziszewo.kosciol.data.mapper.ContactMapper
import pl.godziszewo.kosciol.data.mapper.HistoryMapper
import pl.godziszewo.kosciol.data.mapper.IntentionsMapper
import pl.godziszewo.kosciol.data.mapper.MassesMapper
import pl.godziszewo.kosciol.data.mapper.NewsMapper
import pl.godziszewo.kosciol.data.source.ChurchDataSourceFactory
import pl.godziszewo.kosciol.domain.models.Announcement
import pl.godziszewo.kosciol.domain.models.Cemetery
import pl.godziszewo.kosciol.domain.models.Confession
import pl.godziszewo.kosciol.domain.models.Contact
import pl.godziszewo.kosciol.domain.models.History
import pl.godziszewo.kosciol.domain.models.Intention
import pl.godziszewo.kosciol.domain.models.Masses
import pl.godziszewo.kosciol.domain.models.News
import pl.godziszewo.kosciol.domain.repository.ChurchRepository
import javax.inject.Inject

class ChurchRepositoryImp @Inject constructor(
    private val dataSourceFactory: ChurchDataSourceFactory, private val newsMapper: NewsMapper,
    private val announcementMapper: AnnouncementsMapper,
    private val intentionMapper: IntentionsMapper,
    private val cemeteryMapper: CemeteryMapper,
    private val contactMapper: ContactMapper,
    private val confessionMapper: ConfessionMapper,
    private val historyMapper: HistoryMapper,
    private val massesMapper: MassesMapper,

    ) : ChurchRepository {
    override suspend fun getNews(): Flow<List<News>> = flow {
        val isCached = dataSourceFactory.getCacheDataSource().isNewsCached()
        val newsList =
            dataSourceFactory.getNewsDataStore(isCached).getNews().map { newsEntity ->
                newsMapper.mapFromEntity(newsEntity)
            }
        saveNews(newsList)
        emit(newsList)
    }

    override suspend fun getAnnouncements(): Flow<Announcement> = flow {
        val isCached = dataSourceFactory.getCacheDataSource().isAnnouncementsCached()
        val announcementEntity =
            dataSourceFactory.getAnnouncementsDataStore(isCached).getAnnouncements()
        val announcement = announcementMapper.mapFromEntity(announcementEntity)
        saveAnnouncements(announcement)
        emit(announcement)
    }

    override suspend fun getIntentions(): Flow<Intention> = flow {
        val isCached = dataSourceFactory.getCacheDataSource().isIntentionsCached()
        val intentionsEntity = dataSourceFactory.getIntentionsDataStore(isCached).getIntentions()
        val intentions = intentionMapper.mapFromEntity(intentionsEntity)
        saveIntentions(intentions)
        emit(intentions)
    }

    override suspend fun getCemetery(): Flow<Cemetery> = flow {
        val isCached = dataSourceFactory.getCacheDataSource().isCemeteryCached()
        val cemeteryEntity = dataSourceFactory.getCemeteryDataStore(isCached).getCemetery()
        val cemetery = cemeteryMapper.mapFromEntity(cemeteryEntity)
        saveCemetery(cemetery)
        emit(cemetery)
    }

    override suspend fun getContact(): Flow<Contact> = flow {
        val isCached = dataSourceFactory.getCacheDataSource().isContactCached()
        val contactEntity = dataSourceFactory.getContactDataStore(isCached).getContact()
        val contact = contactMapper.mapFromEntity(contactEntity)
        saveContact(contact)
        emit(contact)
    }

    override suspend fun getConfession(): Flow<Confession> = flow {
        val isCached = dataSourceFactory.getCacheDataSource().isConfessionCached()
        val confessionEntity = dataSourceFactory.getConfessionDataStore(isCached).getConfession()
        val confession = confessionMapper.mapFromEntity(confessionEntity)
        saveConfession(confession)
        emit(confession)
    }

    override suspend fun getHistory(): Flow<History> = flow {
        val isCached = dataSourceFactory.getCacheDataSource().isHistoryCached()
        val historyEntity = dataSourceFactory.getHistoryDataStore(isCached).getHistory()
        val history = historyMapper.mapFromEntity(historyEntity)
        saveHistory(history)
        emit(history)
    }

    override suspend fun getMasses(): Flow<Masses> = flow {
        val isCached = dataSourceFactory.getCacheDataSource().isMassesCached()
        val massesEntity = dataSourceFactory.getMassesDataStore(isCached).getMasses()
        val masses = massesMapper.mapFromEntity(massesEntity)
        saveMasses(masses)
        emit(masses)
    }

    override suspend fun saveNews(listNews: List<News>) {
        val newsEntities = listNews.map { news ->
            newsMapper.mapToEntity(news)
        }
        dataSourceFactory.getCacheDataSource().saveNews(newsEntities)
    }

    override suspend fun saveAnnouncements(announcement: Announcement) {
        val announcementEntity = announcementMapper.mapToEntity(announcement)
        dataSourceFactory.getCacheDataSource().saveAnnouncements(announcementEntity)
    }

    override suspend fun saveIntentions(intention: Intention) {
        val intentionEntity = intentionMapper.mapToEntity(intention)
        dataSourceFactory.getCacheDataSource().saveIntentions(intentionEntity)
    }

    override suspend fun saveCemetery(cemetery: Cemetery) {
        val cemeteryEntity = cemeteryMapper.mapToEntity(cemetery)
        dataSourceFactory.getCacheDataSource().saveCemetery(cemeteryEntity)
    }

    override suspend fun saveContact(contact: Contact) {
        val contactEntity = contactMapper.mapToEntity(contact)
        dataSourceFactory.getCacheDataSource().saveContact(contactEntity)
    }

    override suspend fun saveConfession(confession: Confession) {
        val confessionEntity = confessionMapper.mapToEntity(confession)
        dataSourceFactory.getCacheDataSource().saveConfession(confessionEntity)
    }

    override suspend fun saveHistory(history: History) {
        val historyEntity = historyMapper.mapToEntity(history)
        dataSourceFactory.getCacheDataSource().saveHistory(historyEntity)
    }

    override suspend fun saveMasses(masses: Masses) {
        val massesEntity = massesMapper.mapToEntity(masses)
        dataSourceFactory.getCacheDataSource().saveMasses(massesEntity)
    }

}