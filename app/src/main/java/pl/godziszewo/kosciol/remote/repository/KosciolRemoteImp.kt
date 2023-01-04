/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/4/23, 7:27 PM
 *
 */

package pl.godziszewo.kosciol.remote.repository

import pl.godziszewo.kosciol.data.models.AktualnosciEntity
import pl.godziszewo.kosciol.data.models.OgloszeniaEntity
import pl.godziszewo.kosciol.data.repository.KosciolRemote
import pl.godziszewo.kosciol.remote.api.KosciolApi
import pl.godziszewo.kosciol.remote.mappers.AktualnosciEntityMapper
import pl.godziszewo.kosciol.remote.mappers.OgloszeniaEntityMapper
import javax.inject.Inject

class KosciolRemoteImp @Inject constructor(
    private val kosciolApi: KosciolApi,
    private val aktualnosciEntityMapper: AktualnosciEntityMapper,
    private val ogloszeniaEntityMapper: OgloszeniaEntityMapper
) : KosciolRemote {
    override suspend fun getAktualnosci(): List<AktualnosciEntity> {
        val list = mutableListOf<AktualnosciEntity>()
        kosciolApi.getAktualnosciUrls().urlList.forEach { url ->
            list.add(aktualnosciEntityMapper.mapFromModel(kosciolApi.getAktualnosci(url)))
        }
        return list
    }

    override suspend fun getOgloszenia(): List<OgloszeniaEntity> {
        val list = mutableListOf<OgloszeniaEntity>()
        kosciolApi.getOgloszeniaUrls().urlList.forEach { url ->
            list.add(ogloszeniaEntityMapper.mapFromModel(kosciolApi.getOgloszenia(url)))
        }
        return list
    }
}