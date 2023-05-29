/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 5/8/23, 8:47 PM
 *
 */

package pl.godziszewo.kosciol.cache.mapper

import pl.godziszewo.kosciol.cache.models.AnnouncementCacheEntity
import pl.godziszewo.kosciol.data.models.AnnouncementEntity
import javax.inject.Inject

class AnnouncementCacheMapper @Inject constructor() : CacheMapper<AnnouncementCacheEntity, AnnouncementEntity> {
    override fun mapFromCached(type: AnnouncementCacheEntity): AnnouncementEntity {
        return AnnouncementEntity(
            text = type.toString()
        )
    }

    override fun mapToCached(type: AnnouncementEntity): AnnouncementCacheEntity {
        TODO("Not yet implemented")
    }
}