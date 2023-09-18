/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/18/23, 3:37 PM
 *
 */

package pl.godziszewo.kosciol.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.godziszewo.kosciol.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.HISTORY_TABLE_NAME)
data class HistoryCacheEntity(
    @PrimaryKey val id: Int = 0,
    val elements1: String? = null,
    val elements2: String? = null,
    val elements3: String? = null,
    val elements4: String? = null,
    val elements5: String? = null,
    val elements6: String? = null
)
