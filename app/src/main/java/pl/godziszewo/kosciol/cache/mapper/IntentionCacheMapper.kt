/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
 *
 */

package pl.godziszewo.kosciol.cache.mapper

import pl.godziszewo.kosciol.cache.models.IntentionCacheEntity
import pl.godziszewo.kosciol.data.models.IntentionEntity
import javax.inject.Inject

class IntentionCacheMapper @Inject constructor() :
    CacheMapper<IntentionCacheEntity, IntentionEntity> {
    override fun mapFromCached(type: IntentionCacheEntity): IntentionEntity {
        return IntentionEntity(
            title = type.title,
            dateRange = type.dateRange ?: "",
            textList = type.elements?.split() ?: emptyList()
        )
    }

    override fun mapToCached(type: IntentionEntity): IntentionCacheEntity {
        return IntentionCacheEntity(
            title = type.title,
            dateRange = type.dateRange,
            elements = type.textList.ifEmpty { null }?.join()
        )

    }
}