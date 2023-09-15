/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 8:16 PM
 *
 */

package pl.godziszewo.kosciol.data.mapper

import pl.godziszewo.kosciol.data.models.ConfessionEntity
import pl.godziszewo.kosciol.domain.models.Confession
import javax.inject.Inject

class ConfessionMapper @Inject constructor() : Mapper<ConfessionEntity, Confession> {
    override fun mapFromEntity(type: ConfessionEntity): Confession {
        return Confession(
            textList = type.textList
        )
    }

    override fun mapToEntity(type: Confession): ConfessionEntity {
        return ConfessionEntity(
            id = 0,
            textList = type.textList
        )
    }
}