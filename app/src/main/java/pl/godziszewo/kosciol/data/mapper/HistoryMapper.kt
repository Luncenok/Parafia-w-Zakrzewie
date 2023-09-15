/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 8:18 PM
 *
 */

package pl.godziszewo.kosciol.data.mapper

import pl.godziszewo.kosciol.data.models.HistoryEntity
import pl.godziszewo.kosciol.domain.models.History
import javax.inject.Inject

class HistoryMapper @Inject constructor() : Mapper<HistoryEntity, History> {
    override fun mapFromEntity(type: HistoryEntity): History {
        return History(
            textList = type.textList
        )
    }

    override fun mapToEntity(type: History): HistoryEntity {
        return HistoryEntity(
            id = 0,
            textList = type.textList
        )
    }
}