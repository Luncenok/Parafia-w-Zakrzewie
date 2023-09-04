/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 6/2/23, 3:53 PM
 *
 */

package pl.godziszewo.kosciol.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.godziszewo.kosciol.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.MASSES_TABLE_NAME)
data class MassesCacheEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val elements: String
)
