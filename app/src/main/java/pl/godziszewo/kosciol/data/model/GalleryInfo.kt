/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 10/24/22, 6:30 PM
 *
 */

package pl.godziszewo.kosciol.data.model

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