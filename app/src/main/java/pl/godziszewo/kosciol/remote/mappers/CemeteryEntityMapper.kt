/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
 *
 */

package pl.godziszewo.kosciol.remote.mappers

import pl.godziszewo.kosciol.data.models.CemeteryEntity
import pl.godziszewo.kosciol.remote.models.CemeteryModel
import javax.inject.Inject

class CemeteryEntityMapper @Inject constructor() :
    EntityMapper<CemeteryModel, CemeteryEntity> {

    override fun mapToEntity(model: CemeteryModel): CemeteryEntity {
        return CemeteryEntity(
            textList = model.textList
        )
    }
}