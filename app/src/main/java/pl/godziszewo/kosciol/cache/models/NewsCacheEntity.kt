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

@Entity(tableName = CacheConstants.NEWS_TABLE_NAME)
data class NewsCacheEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val date: String, // niedziela, 12.02.2023
    val short: String,
    val mainImg: String,
    val elements: List<String>? = null,
    val images: List<String>? = null,
)
