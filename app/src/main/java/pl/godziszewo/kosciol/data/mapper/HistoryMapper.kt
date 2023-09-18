/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/18/23, 3:39 PM
 *
 */

package pl.godziszewo.kosciol.data.mapper

import pl.godziszewo.kosciol.data.models.HistoryEntity
import pl.godziszewo.kosciol.domain.models.History
import javax.inject.Inject

class HistoryMapper @Inject constructor() : Mapper<HistoryEntity, History> {
    override fun mapFromEntity(type: HistoryEntity): History {
        return History(
            textList1 = type.textList1,
            textList2 = type.textList2,
            textList3 = type.textList3,
            textList4 = type.textList4,
            textList5 = type.textList5,
            textList6 = type.textList6
        )
    }

    override fun mapToEntity(type: History): HistoryEntity {
        return HistoryEntity(
            id = 0,
            textList1 = type.textList1,
            textList2 = type.textList2,
            textList3 = type.textList3,
            textList4 = type.textList4,
            textList5 = type.textList5,
            textList6 = type.textList6
        )
    }
}