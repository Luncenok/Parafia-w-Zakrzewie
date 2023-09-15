/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
 *
 */

package pl.godziszewo.kosciol.data.mapper

import pl.godziszewo.kosciol.data.models.MassesEntity
import pl.godziszewo.kosciol.domain.models.Masses
import javax.inject.Inject

class MassesMapper @Inject constructor() : Mapper<MassesEntity, Masses> {
    override fun mapFromEntity(type: MassesEntity): Masses {
        return Masses(
            textList = type.textList
        )
    }

    override fun mapToEntity(type: Masses): MassesEntity {
        return MassesEntity(
            id = 0,
            textList = type.textList
        )
    }
}