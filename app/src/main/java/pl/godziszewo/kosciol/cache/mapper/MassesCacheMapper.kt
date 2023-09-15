/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
 *
 */

package pl.godziszewo.kosciol.cache.mapper

import pl.godziszewo.kosciol.cache.models.MassesCacheEntity
import pl.godziszewo.kosciol.data.models.MassesEntity
import javax.inject.Inject

class MassesCacheMapper @Inject constructor() : CacheMapper<MassesCacheEntity, MassesEntity> {
    override fun mapFromCached(type: MassesCacheEntity): MassesEntity {
        return MassesEntity(
            textList = type.elements.split() ?: emptyList()
        )
    }

    override fun mapToCached(type: MassesEntity): MassesCacheEntity {
        return MassesCacheEntity(
            elements = type.textList.ifEmpty { null }?.join()
        )

    }
}