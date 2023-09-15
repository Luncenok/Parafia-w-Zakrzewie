/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:29 PM
 *
 */

package pl.godziszewo.kosciol.cache.mapper

import pl.godziszewo.kosciol.cache.models.AnnouncementCacheEntity
import pl.godziszewo.kosciol.data.models.AnnouncementEntity
import javax.inject.Inject

class AnnouncementCacheMapper @Inject constructor() : CacheMapper<AnnouncementCacheEntity, AnnouncementEntity> {
    override fun mapFromCached(type: AnnouncementCacheEntity): AnnouncementEntity {
        return AnnouncementEntity(
            title = type.title,
            date = type.date,
            short = type.short,
            textList = type.elements?.split() ?: emptyList()
        )
    }

    override fun mapToCached(type: AnnouncementEntity): AnnouncementCacheEntity {
        return AnnouncementCacheEntity(
            title = type.title,
            date = type.date,
            short = type.short,
            elements = type.textList.ifEmpty { null }?.join()
        )
    }
}