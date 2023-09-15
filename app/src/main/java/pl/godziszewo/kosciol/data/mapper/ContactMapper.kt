/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
 *
 */

package pl.godziszewo.kosciol.data.mapper

import pl.godziszewo.kosciol.data.models.ContactEntity
import pl.godziszewo.kosciol.domain.models.Contact
import javax.inject.Inject

class ContactMapper @Inject constructor() : Mapper<ContactEntity, Contact> {
    override fun mapFromEntity(type: ContactEntity): Contact {
        return Contact(
            textList = type.textList
        )
    }

    override fun mapToEntity(type: Contact): ContactEntity {
        return ContactEntity(
            id = 0,
            textList = type.textList
        )
    }
}