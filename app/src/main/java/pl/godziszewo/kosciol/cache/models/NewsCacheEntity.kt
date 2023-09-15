/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 6:55 PM
 *
 */

package pl.godziszewo.kosciol.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.godziszewo.kosciol.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.NEWS_TABLE_NAME)
data class NewsCacheEntity(
    val title: String,
    val date: String, // niedziela, 12.02.2023
    @PrimaryKey val short: String,
    val mainImg: String,
    val elements: String? = null,
    val images: String? = null,
)
