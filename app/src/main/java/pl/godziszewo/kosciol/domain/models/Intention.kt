/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 8:18 PM
 *
 */

package pl.godziszewo.kosciol.domain.models

data class Intention(
    val id: Int,
    val title: String,
    val dateRange: String,
    val textList: List<String>
)
