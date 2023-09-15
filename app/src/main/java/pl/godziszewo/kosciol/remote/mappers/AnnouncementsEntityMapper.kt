/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:28 PM
 *
 */

package pl.godziszewo.kosciol.remote.mappers

import pl.godziszewo.kosciol.data.models.AnnouncementEntity
import pl.godziszewo.kosciol.remote.models.AnnouncementsModel
import javax.inject.Inject

class AnnouncementsEntityMapper @Inject constructor() :
    EntityMapper<AnnouncementsModel, AnnouncementEntity> {

    override fun mapToEntity(model: AnnouncementsModel): AnnouncementEntity {
        return AnnouncementEntity(
            title = model.textList[0],
            date = model.textList[1],
            short = model.textList[2],
            textList = model.textList
        )
    }
}