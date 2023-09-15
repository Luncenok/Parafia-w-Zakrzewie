/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
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
            textList = model.textList
        )
    }
}