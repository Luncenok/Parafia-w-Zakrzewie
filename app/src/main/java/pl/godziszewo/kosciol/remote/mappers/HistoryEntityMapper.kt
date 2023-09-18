/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/18/23, 3:33 PM
 *
 */

package pl.godziszewo.kosciol.remote.mappers

import pl.godziszewo.kosciol.data.models.HistoryEntity
import pl.godziszewo.kosciol.remote.models.HistoryModel
import javax.inject.Inject

class HistoryEntityMapper @Inject constructor() :
    EntityMapper<HistoryModel, HistoryEntity> {

    override fun mapToEntity(model: HistoryModel): HistoryEntity {
        return HistoryEntity(
            textList1 = model.textList1,
            textList2 = model.textList2,
            textList3 = model.textList3,
            textList4 = model.textList4,
            textList5 = model.textList5,
            textList6 = model.textList6
        )
    }
}