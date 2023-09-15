/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
 *
 */

package pl.godziszewo.kosciol.remote.mappers

import pl.godziszewo.kosciol.data.models.ContactEntity
import pl.godziszewo.kosciol.remote.models.ContactModel
import javax.inject.Inject

class ContactEntityMapper @Inject constructor() :
    EntityMapper<ContactModel, ContactEntity> {

    override fun mapToEntity(model: ContactModel): ContactEntity {
        return ContactEntity(
            textList = model.textList
        )
    }
}