/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
 *
 */

package pl.godziszewo.kosciol.cache.mapper

import pl.godziszewo.kosciol.cache.models.CemeteryCacheEntity
import pl.godziszewo.kosciol.data.models.CemeteryEntity
import javax.inject.Inject

class CemeteryCacheMapper @Inject constructor() : CacheMapper<CemeteryCacheEntity, CemeteryEntity> {
    override fun mapFromCached(type: CemeteryCacheEntity): CemeteryEntity {
        return CemeteryEntity(
            textList = type.elements?.split() ?: emptyList()
        )
    }

    override fun mapToCached(type: CemeteryEntity): CemeteryCacheEntity {
        return CemeteryCacheEntity(
            elements = type.textList.ifEmpty { null }?.join()
        )

    }
}