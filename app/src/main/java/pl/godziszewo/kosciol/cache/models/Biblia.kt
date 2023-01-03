/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/3/23, 9:08 PM
 *
 */

package pl.godziszewo.kosciol.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "biblias")
data class Biblia(
    @PrimaryKey(autoGenerate = true) val id: Int,

    @ColumnInfo(name = "ksiega") val ksiega: String?,
    @ColumnInfo(name = "rozdzial") val rozdzial: String?,
    @ColumnInfo(name = "werset") val werset: String?
)