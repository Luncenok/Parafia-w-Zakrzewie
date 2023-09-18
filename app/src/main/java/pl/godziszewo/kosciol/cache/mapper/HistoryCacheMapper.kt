/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/18/23, 3:38 PM
 *
 */

package pl.godziszewo.kosciol.cache.mapper

import pl.godziszewo.kosciol.cache.models.HistoryCacheEntity
import pl.godziszewo.kosciol.data.models.HistoryEntity
import javax.inject.Inject

class HistoryCacheMapper @Inject constructor() : CacheMapper<HistoryCacheEntity, HistoryEntity> {
    override fun mapFromCached(type: HistoryCacheEntity): HistoryEntity {
        return HistoryEntity(
            textList1 = type.elements1.split() ?: emptyList(),
            textList2 = type.elements2.split() ?: emptyList(),
            textList3 = type.elements3.split() ?: emptyList(),
            textList4 = type.elements4.split() ?: emptyList(),
            textList5 = type.elements5.split() ?: emptyList(),
            textList6 = type.elements6.split() ?: emptyList()
        )
    }

    override fun mapToCached(type: HistoryEntity): HistoryCacheEntity {
        return HistoryCacheEntity(
            elements1 = type.textList1.ifEmpty { null }?.join(),
            elements2 = type.textList2.ifEmpty { null }?.join(),
            elements3 = type.textList3.ifEmpty { null }?.join(),
            elements4 = type.textList4.ifEmpty { null }?.join(),
            elements5 = type.textList5.ifEmpty { null }?.join(),
            elements6 = type.textList6.ifEmpty { null }?.join()
        )

    }
}