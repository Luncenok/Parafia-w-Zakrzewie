/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
 *
 */

package pl.godziszewo.kosciol.cache.mapper

import pl.godziszewo.kosciol.cache.models.ConfessionCacheEntity
import pl.godziszewo.kosciol.data.models.ConfessionEntity
import javax.inject.Inject

class ConfessionCacheMapper @Inject constructor() :
    CacheMapper<ConfessionCacheEntity, ConfessionEntity> {
    override fun mapFromCached(type: ConfessionCacheEntity): ConfessionEntity {
        return ConfessionEntity(
            textList = type.elements.split() ?: emptyList()
        )
    }

    override fun mapToCached(type: ConfessionEntity): ConfessionCacheEntity {
        return ConfessionCacheEntity(
            elements = type.textList.ifEmpty { null }?.join()
        )

    }
}