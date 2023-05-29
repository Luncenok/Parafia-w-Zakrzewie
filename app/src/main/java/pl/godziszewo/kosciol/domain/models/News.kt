/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/4/23, 9:54 PM
 *
 */

package pl.godziszewo.kosciol.domain.models

data class News(
    val id: Int,
    val title: String,
    val date: String, // niedziela, 12.02.2023
    val short: String,
    val mainImg: String,
    val elements: List<String>,
    val images: List<String>,
)
