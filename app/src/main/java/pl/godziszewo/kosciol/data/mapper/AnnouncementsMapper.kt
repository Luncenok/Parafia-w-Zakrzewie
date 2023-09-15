/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
 *
 */

package pl.godziszewo.kosciol.data.mapper

import pl.godziszewo.kosciol.data.models.AnnouncementEntity
import pl.godziszewo.kosciol.domain.models.Announcement
import javax.inject.Inject

class AnnouncementsMapper @Inject constructor() : Mapper<AnnouncementEntity, Announcement> {
    override fun mapFromEntity(type: AnnouncementEntity): Announcement {
        return Announcement(
            id = type.id ?: 0,
            title = type.title,
            date = type.date,
            short = type.short,
            textList = type.textList
        )
    }

    override fun mapToEntity(type: Announcement): AnnouncementEntity {
        return AnnouncementEntity(
            id = type.id,
            title = type.title,
            date = type.date,
            short = type.short,
            textList = type.textList
        )
    }
}