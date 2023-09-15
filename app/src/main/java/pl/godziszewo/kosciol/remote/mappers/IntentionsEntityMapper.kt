/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
 *
 */

package pl.godziszewo.kosciol.remote.mappers

import pl.godziszewo.kosciol.data.models.IntentionEntity
import pl.godziszewo.kosciol.remote.models.IntentionsModel
import javax.inject.Inject

class IntentionsEntityMapper @Inject constructor() :
    EntityMapper<IntentionsModel, IntentionEntity> {

    override fun mapToEntity(model: IntentionsModel): IntentionEntity {
        return IntentionEntity(
            title = model.textList[0],
            dateRange = model.textList[1],
            textList = model.textList
        )
    }
}