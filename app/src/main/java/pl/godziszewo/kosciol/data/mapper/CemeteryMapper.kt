/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
 *
 */

package pl.godziszewo.kosciol.data.mapper

import pl.godziszewo.kosciol.data.models.CemeteryEntity
import pl.godziszewo.kosciol.domain.models.Cemetery
import javax.inject.Inject

class CemeteryMapper @Inject constructor() : Mapper<CemeteryEntity, Cemetery> {
    override fun mapFromEntity(type: CemeteryEntity): Cemetery {
        return Cemetery(
            textList = type.textList
        )
    }

    override fun mapToEntity(type: Cemetery): CemeteryEntity {
        return CemeteryEntity(
            id = 0,
            textList = type.textList
        )
    }
}