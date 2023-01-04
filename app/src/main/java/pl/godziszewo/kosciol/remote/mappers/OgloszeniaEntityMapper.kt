/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/4/23, 7:29 PM
 *
 */

package pl.godziszewo.kosciol.remote.mappers

import pl.godziszewo.kosciol.data.models.OgloszeniaEntity
import pl.godziszewo.kosciol.remote.models.OgloszeniaModel

class OgloszeniaEntityMapper : EntityMapper<OgloszeniaModel, OgloszeniaEntity> {
    override fun mapFromModel(model: OgloszeniaModel): OgloszeniaEntity {
        return OgloszeniaEntity(
            text = model.introList.plus(model.ogloszeniaList).joinToString("\n")
        )
    }
}