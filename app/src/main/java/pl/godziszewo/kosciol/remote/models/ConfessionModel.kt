/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:29 PM
 *
 */

package pl.godziszewo.kosciol.remote.models

import pl.droidsonroids.jspoon.annotation.Selector

data class ConfessionModel(
    @Selector(".content li") val textList: List<String>
)
