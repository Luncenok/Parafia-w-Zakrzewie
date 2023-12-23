/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 12/23/23, 2:05 PM
 *
 */

package pl.godziszewo.kosciol.remote.repository

import pl.godziszewo.kosciol.data.models.AnnouncementEntity
import pl.godziszewo.kosciol.data.models.CemeteryEntity
import pl.godziszewo.kosciol.data.models.ConfessionEntity
import pl.godziszewo.kosciol.data.models.ContactEntity
import pl.godziszewo.kosciol.data.models.HistoryEntity
import pl.godziszewo.kosciol.data.models.IntentionEntity
import pl.godziszewo.kosciol.data.models.MassesEntity
import pl.godziszewo.kosciol.data.models.NewsEntity
import pl.godziszewo.kosciol.data.repository.ChurchRemote
import pl.godziszewo.kosciol.remote.api.ChurchService
import pl.godziszewo.kosciol.remote.mappers.AnnouncementsEntityMapper
import pl.godziszewo.kosciol.remote.mappers.CemeteryEntityMapper
import pl.godziszewo.kosciol.remote.mappers.ConfessionEntityMapper
import pl.godziszewo.kosciol.remote.mappers.ContactEntityMapper
import pl.godziszewo.kosciol.remote.mappers.HistoryEntityMapper
import pl.godziszewo.kosciol.remote.mappers.IntentionsEntityMapper
import pl.godziszewo.kosciol.remote.mappers.MassesEntityMapper
import pl.godziszewo.kosciol.remote.mappers.NewsEntityMapper
import javax.inject.Inject

class ChurchRemoteImp @Inject constructor(
    private val churchService: ChurchService,
    private val newsEntityMapper: NewsEntityMapper,
    private val announcementsEntityMapper: AnnouncementsEntityMapper,
    private val intentionEntityMapper: IntentionsEntityMapper,
    private val cemeteryEntityMapper: CemeteryEntityMapper,
    private val contactEntityMapper: ContactEntityMapper,
    private val confessionEntityMapper: ConfessionEntityMapper,
    private val historyEntityMapper: HistoryEntityMapper,
    private val massesEntityMapper: MassesEntityMapper,
) : ChurchRemote {
    override suspend fun getNews(): List<NewsEntity> {
        return churchService.getNewsUrls().urlList.map { url ->
            newsEntityMapper.mapToEntity(churchService.getNews(url))
        }
    }

    override suspend fun getAnnouncements(): AnnouncementEntity {
        return announcementsEntityMapper.mapToEntity(churchService.getAnnouncements())
//        return churchService.getAnnouncementsUrls().urlList.map { url ->
//            announcementsEntityMapper.mapToEntity(churchService.getAnnouncements(url))
//        }
    }

    override suspend fun getIntentions(): IntentionEntity {
        return intentionEntityMapper.mapToEntity(churchService.getIntentions())
//        return churchService.getIntentionsUrls().urlList.map { url ->
//            intentionEntityMapper.mapToEntity(churchService.getIntentions(url))
//        }
    }

    override suspend fun getCemetery(): CemeteryEntity {
        return cemeteryEntityMapper.mapToEntity(churchService.getCemetery())
    }

    override suspend fun getContact(): ContactEntity {
        return contactEntityMapper.mapToEntity(churchService.getContact())
    }

    override suspend fun getConfession(): ConfessionEntity {
        return confessionEntityMapper.mapToEntity(churchService.getConfession())
    }

    override suspend fun getHistory(): HistoryEntity {
        return historyEntityMapper.mapToEntity(churchService.getHistory())
    }

    override suspend fun getMasses(): MassesEntity {
        return massesEntityMapper.mapToEntity(churchService.getMasses())
    }

}