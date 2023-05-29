/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/4/23, 9:14 PM
 *
 */

package pl.godziszewo.kosciol.data.source

import pl.godziszewo.kosciol.data.models.NewsEntity
import pl.godziszewo.kosciol.data.models.AnnouncementEntity
import pl.godziszewo.kosciol.data.repository.ChurchDataSource
import pl.godziszewo.kosciol.data.repository.ChurchRemote
import javax.inject.Inject

class ChurchRemoteDataSource @Inject constructor(
    private val churchRemote: ChurchRemote
) : ChurchDataSource {
    override suspend fun getNews(): List<NewsEntity> {
        return churchRemote.getNews()
    }

    override suspend fun getOgloszenia(): List<AnnouncementEntity> {
        return churchRemote.getOgloszenia()
    }

    override suspend fun saveNews(listAktualnosci: List<NewsEntity>) {
        throw UnsupportedOperationException("Save aktualnosci is not supported for RemoteDataSource")
    }

    override suspend fun saveOgloszenia(listOgloszenia: List<AnnouncementEntity>) {
        throw UnsupportedOperationException("Save ogloszenia is not supported for RemoteDataSource")
    }

    override suspend fun isCached(): Boolean {
        throw UnsupportedOperationException("Cache is not supported for RemoteDataSource.")
    }
}