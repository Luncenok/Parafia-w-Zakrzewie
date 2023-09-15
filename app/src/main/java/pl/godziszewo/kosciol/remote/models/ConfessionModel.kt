/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 11:40 PM
 *
 */

package pl.godziszewo.kosciol.remote.models

import pl.droidsonroids.jspoon.annotation.Selector

data class ConfessionModel(
    @Selector(
        "#sacrament2 h3, #sacrament2 p, #sacrament2 li",
        attr = "outerHtml"
    ) val textList: List<String> = emptyList()
)
