/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
 *
 */

package pl.godziszewo.kosciol.remote.mappers

import pl.godziszewo.kosciol.data.models.ConfessionEntity
import pl.godziszewo.kosciol.remote.models.ConfessionModel
import javax.inject.Inject

class ConfessionEntityMapper @Inject constructor() :
    EntityMapper<ConfessionModel, ConfessionEntity> {

    override fun mapToEntity(model: ConfessionModel): ConfessionEntity {
        return ConfessionEntity(
            textList = model.textList
        )
    }
}