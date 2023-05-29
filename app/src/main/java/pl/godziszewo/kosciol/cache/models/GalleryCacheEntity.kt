/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 3/10/23, 9:37 PM
 *
 */

package pl.godziszewo.kosciol.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.godziszewo.kosciol.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.GALLERY_TABLE_NAME)
data class GalleryCacheEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    @ColumnInfo(name = "photosrc") val photosrc: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "linki") var linki: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "date") val date: String
)