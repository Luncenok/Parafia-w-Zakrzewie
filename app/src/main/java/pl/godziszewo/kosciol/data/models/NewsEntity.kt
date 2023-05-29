/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/4/23, 7:06 PM
 *
 */

package pl.godziszewo.kosciol.data.models

data class NewsEntity(
    val id: Int? = null,
    val title: String,
    val date: String,
    val short: String,
    val mainImg: String,
    val textList: List<String>,
    val imgUrls: List<String>
)
