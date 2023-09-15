/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 7:14 PM
 *
 */

package pl.godziszewo.kosciol.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.godziszewo.kosciol.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.INTENTIONS_TABLE_NAME)
data class IntentionCacheEntity(
    @PrimaryKey val title: String,
    val dateRange: String? = null, // niedziela 05.03.2023   -   niedziela 12.03.2023
    val elements: String? = null,
)
