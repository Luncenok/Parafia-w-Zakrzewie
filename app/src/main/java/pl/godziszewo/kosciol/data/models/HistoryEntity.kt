/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/18/23, 3:33 PM
 *
 */

package pl.godziszewo.kosciol.data.models

data class HistoryEntity(
    val id: Int = 0,
    val textList1: List<String>,
    val textList2: List<String>,
    val textList3: List<String>,
    val textList4: List<String>,
    val textList5: List<String>,
    val textList6: List<String>
)
