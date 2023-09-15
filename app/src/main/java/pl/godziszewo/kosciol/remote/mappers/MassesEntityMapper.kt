/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
 *
 */

package pl.godziszewo.kosciol.remote.mappers

import pl.godziszewo.kosciol.data.models.MassesEntity
import pl.godziszewo.kosciol.remote.models.MassesModel
import javax.inject.Inject

class MassesEntityMapper @Inject constructor() :
    EntityMapper<MassesModel, MassesEntity> {

    override fun mapToEntity(model: MassesModel): MassesEntity {
        return MassesEntity(
            textList = model.textList
        )
    }
}