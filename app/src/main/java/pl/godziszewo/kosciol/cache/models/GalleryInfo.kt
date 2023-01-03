/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/3/23, 9:10 PM
 *
 */

package pl.godziszewo.kosciol.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gallery")
data class GalleryInfo(
    @PrimaryKey(autoGenerate = true) val id: Int,

    @ColumnInfo(name = "photosrc") val photosrc: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "linki") var linki: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "date") val date: String
)