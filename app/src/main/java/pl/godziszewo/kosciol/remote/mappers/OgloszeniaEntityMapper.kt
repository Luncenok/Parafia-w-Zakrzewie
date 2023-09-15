/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 6:18 PM
 *
 */

package pl.godziszewo.kosciol.remote.mappers

import pl.godziszewo.kosciol.data.models.AnnouncementEntity
import pl.godziszewo.kosciol.remote.models.OgloszeniaModel
import javax.inject.Inject

class OgloszeniaEntityMapper @Inject constructor() :
    EntityMapper<OgloszeniaModel, AnnouncementEntity> {

    override fun mapToEntity(model: OgloszeniaModel): AnnouncementEntity {
        return AnnouncementEntity(
            text = model.introList.plus(model.ogloszeniaList).joinToString("\n")
        )
    }
}