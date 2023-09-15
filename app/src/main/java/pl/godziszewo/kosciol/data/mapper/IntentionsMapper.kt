/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
 *
 */

package pl.godziszewo.kosciol.data.mapper

import pl.godziszewo.kosciol.data.models.IntentionEntity
import pl.godziszewo.kosciol.domain.models.Intention
import javax.inject.Inject

class IntentionsMapper @Inject constructor() : Mapper<IntentionEntity, Intention> {
    override fun mapFromEntity(type: IntentionEntity): Intention {
        return Intention(
            id = type.id ?: 0,
            title = type.title,
            dateRange = type.dateRange,
            textList = type.textList
        )
    }

    override fun mapToEntity(type: Intention): IntentionEntity {
        return IntentionEntity(
            id = type.id,
            title = type.title,
            dateRange = type.dateRange,
            textList = type.textList
        )
    }
}