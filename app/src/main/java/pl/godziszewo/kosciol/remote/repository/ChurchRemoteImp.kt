/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/4/23, 7:27 PM
 *
 */

package pl.godziszewo.kosciol.remote.repository

import pl.godziszewo.kosciol.data.models.NewsEntity
import pl.godziszewo.kosciol.data.models.AnnouncementEntity
import pl.godziszewo.kosciol.data.repository.ChurchRemote
import pl.godziszewo.kosciol.remote.api.ChurchService
import pl.godziszewo.kosciol.remote.mappers.NewsEntityMapper
import pl.godziszewo.kosciol.remote.mappers.OgloszeniaEntityMapper
import javax.inject.Inject

class ChurchRemoteImp @Inject constructor(
    private val churchService: ChurchService,
    private val newsEntityMapper: NewsEntityMapper,
    private val ogloszeniaEntityMapper: OgloszeniaEntityMapper
) : ChurchRemote {
    override suspend fun getNews(): List<NewsEntity> {
        return churchService.getNewsUrls().urlList.map { url ->
            newsEntityMapper.mapToEntity(churchService.getNews(url))
        }
    }

    override suspend fun getOgloszenia(): List<AnnouncementEntity> {
        return churchService.getOgloszeniaUrls().urlList.map { url ->
            ogloszeniaEntityMapper.mapFromModel(churchService.getOgloszenia(url))
        }
    }
}