/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 3/10/23, 9:37 PM
 *
 */

package pl.godziszewo.kosciol.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.godziszewo.kosciol.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.ANNOUNCEMENT_TABLE_NAME)
data class AnnouncementCacheEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val date: String, // niedziela 05.03.2023
    val elements: List<String>? = null,
)
