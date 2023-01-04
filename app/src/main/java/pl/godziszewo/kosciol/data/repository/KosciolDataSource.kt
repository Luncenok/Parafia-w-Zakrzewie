/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/4/23, 8:05 PM
 *
 */

package pl.godziszewo.kosciol.data.repository

import pl.godziszewo.kosciol.data.models.AktualnosciEntity
import pl.godziszewo.kosciol.data.models.OgloszeniaEntity

interface KosciolDataSource {
    // Remote and cache
    suspend fun getAktualnosci(): List<AktualnosciEntity>
    suspend fun getOgloszenia(): List<OgloszeniaEntity>

    // Cache
    suspend fun saveAktualnosci(listAktualnosci: List<AktualnosciEntity>)
    suspend fun saveOgloszenia(listOgloszenia: List<OgloszeniaEntity>)
}