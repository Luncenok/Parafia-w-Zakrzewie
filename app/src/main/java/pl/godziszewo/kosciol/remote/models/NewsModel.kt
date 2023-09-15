/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 6:18 PM
 *
 */

package pl.godziszewo.kosciol.remote.models

import pl.droidsonroids.jspoon.annotation.Selector

data class NewsModel(
    @Selector(
        ".content h3, .content p, .content h2",
        attr = "outerHtml"
    ) val textList: List<String> = emptyList(),
    @Selector(value = ".content img", attr = "src") val imgSrcList: List<String> = emptyList()
)
