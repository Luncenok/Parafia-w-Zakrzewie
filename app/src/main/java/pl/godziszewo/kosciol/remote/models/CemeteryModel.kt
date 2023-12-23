/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 12/23/23, 2:42 PM
 *
 */

package pl.godziszewo.kosciol.remote.models

import pl.droidsonroids.jspoon.annotation.Selector

data class CemeteryModel(
    @Selector(
        ".graveyard > h3, .gravetile h3, .gravetile p, .graveyard-header p, .graveyard-header ul, .graveyard-header a",
        attr = "outerHtml"
    ) val textList: List<String> = emptyList(),
)
