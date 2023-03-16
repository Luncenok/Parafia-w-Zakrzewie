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

@Entity(tableName = "masses")
data class MassesCacheEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val elements: List<String>
)
