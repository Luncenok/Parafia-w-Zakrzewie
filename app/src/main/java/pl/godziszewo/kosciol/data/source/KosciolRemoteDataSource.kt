/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/4/23, 9:14 PM
 *
 */

package pl.godziszewo.kosciol.data.source

import pl.godziszewo.kosciol.data.models.AktualnosciEntity
import pl.godziszewo.kosciol.data.models.OgloszeniaEntity
import pl.godziszewo.kosciol.data.repository.KosciolDataSource
import pl.godziszewo.kosciol.data.repository.KosciolRemote
import javax.inject.Inject

class KosciolRemoteDataSource @Inject constructor(
    private val kosciolRemote: KosciolRemote
) : KosciolDataSource {
    override suspend fun getAktualnosci(): List<AktualnosciEntity> {
        return kosciolRemote.getAktualnosci()
    }

    override suspend fun getOgloszenia(): List<OgloszeniaEntity> {
        return kosciolRemote.getOgloszenia()
    }

    override suspend fun saveAktualnosci(listAktualnosci: List<AktualnosciEntity>) {
        throw UnsupportedOperationException("Save aktualnosci is not supported for RemoteDataSource")
    }

    override suspend fun saveOgloszenia(listOgloszenia: List<OgloszeniaEntity>) {
        throw UnsupportedOperationException("Save ogloszenia is not supported for RemoteDataSource")
    }
}