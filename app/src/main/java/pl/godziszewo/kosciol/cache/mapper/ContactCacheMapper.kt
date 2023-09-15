/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
 *
 */

package pl.godziszewo.kosciol.cache.mapper

import pl.godziszewo.kosciol.cache.models.ContactCacheEntity
import pl.godziszewo.kosciol.data.models.ContactEntity
import javax.inject.Inject

class ContactCacheMapper @Inject constructor() : CacheMapper<ContactCacheEntity, ContactEntity> {
    override fun mapFromCached(type: ContactCacheEntity): ContactEntity {
        return ContactEntity(
            textList = type.elements?.split() ?: emptyList()
        )
    }

    override fun mapToCached(type: ContactEntity): ContactCacheEntity {
        return ContactCacheEntity(
            elements = type.textList.ifEmpty { null }?.join()
        )

    }
}