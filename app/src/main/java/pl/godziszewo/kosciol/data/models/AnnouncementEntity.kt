/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:29 PM
 *
 */

package pl.godziszewo.kosciol.data.models

data class AnnouncementEntity(
    val id: Int? = null,
    val title: String,
    val date: String,
    val short: String,
    val textList: List<String>,
)
