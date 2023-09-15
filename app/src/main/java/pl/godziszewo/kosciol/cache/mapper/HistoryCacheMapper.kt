/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
 *
 */

package pl.godziszewo.kosciol.cache.mapper

import pl.godziszewo.kosciol.cache.models.HistoryCacheEntity
import pl.godziszewo.kosciol.data.models.HistoryEntity
import javax.inject.Inject

class HistoryCacheMapper @Inject constructor() : CacheMapper<HistoryCacheEntity, HistoryEntity> {
    override fun mapFromCached(type: HistoryCacheEntity): HistoryEntity {
        return HistoryEntity(
            textList = type.elements.split() ?: emptyList()
        )
    }

    override fun mapToCached(type: HistoryEntity): HistoryCacheEntity {
        return HistoryCacheEntity(
            elements = type.textList.ifEmpty { null }?.join()
        )

    }
}