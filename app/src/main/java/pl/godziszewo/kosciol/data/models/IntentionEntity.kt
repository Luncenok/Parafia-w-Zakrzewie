/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 7:22 PM
 *
 */

package pl.godziszewo.kosciol.data.models

data class IntentionEntity(
    val id: Int? = null,
    val title: String,
    val dateRange: String,
    val textList: List<String>
)
