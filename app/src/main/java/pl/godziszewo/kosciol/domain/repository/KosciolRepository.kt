/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/4/23, 9:50 PM
 *
 */

package pl.godziszewo.kosciol.domain.repository

import pl.godziszewo.kosciol.data.models.AktualnosciEntity
import pl.godziszewo.kosciol.data.models.OgloszeniaEntity

interface KosciolRepository {
    // Remote and cache
    suspend fun getAktualnosci(): List<AktualnosciEntity>
    suspend fun getOgloszenia(): List<OgloszeniaEntity>

    // Cache
    suspend fun saveAktualnosci(listAktualnosci: List<AktualnosciEntity>)
    suspend fun saveOgloszenia(listOgloszenia: List<OgloszeniaEntity>)
}