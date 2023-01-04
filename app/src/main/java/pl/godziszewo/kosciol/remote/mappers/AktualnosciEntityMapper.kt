/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/4/23, 7:29 PM
 *
 */

package pl.godziszewo.kosciol.remote.mappers

import pl.godziszewo.kosciol.data.models.AktualnosciEntity
import pl.godziszewo.kosciol.remote.models.AktualnosciModel

class AktualnosciEntityMapper : EntityMapper<AktualnosciModel, AktualnosciEntity> {
    override fun mapFromModel(model: AktualnosciModel): AktualnosciEntity {
        return AktualnosciEntity(
            text = model.textList.joinToString("\n"),
            imgUrls = model.imgSrcList
        )
    }
}