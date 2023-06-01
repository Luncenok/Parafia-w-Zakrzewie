/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 5/29/23, 11:38 PM
 *
 */

package pl.godziszewo.kosciol.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pl.godziszewo.kosciol.data.mapper.NewsMapper
import pl.godziszewo.kosciol.data.models.AnnouncementEntity
import pl.godziszewo.kosciol.data.source.ChurchDataSourceFactory
import pl.godziszewo.kosciol.domain.models.News
import pl.godziszewo.kosciol.domain.repository.ChurchRepository
import javax.inject.Inject

class ChurchRepositoryImp @Inject constructor(
    private val dataSourceFactory: ChurchDataSourceFactory,
    private val newsMapper: NewsMapper,
) : ChurchRepository {
    override suspend fun getNews(): Flow<List<News>> = flow {
        val isCached = dataSourceFactory.getCacheDataSource().isCached()
        val characterList =
            dataSourceFactory.getDataStore(isCached).getNews().map { newsEntity ->
                newsMapper.mapFromEntity(newsEntity)
            }
        saveNews(characterList)
        emit(characterList)
    }

    override suspend fun getOgloszenia(): Flow<List<AnnouncementEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(listAktualnosci: List<News>) {
        val newsEntities = listAktualnosci.map { character ->
            newsMapper.mapToEntity(character)
        }
        dataSourceFactory.getCacheDataSource().saveNews(newsEntities)
    }

    override suspend fun saveOgloszenia(listOgloszenia: List<AnnouncementEntity>) {
        TODO("Not yet implemented")
    }
}