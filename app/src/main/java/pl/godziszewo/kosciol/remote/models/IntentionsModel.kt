/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 11:41 PM
 *
 */

package pl.godziszewo.kosciol.remote.models

import pl.droidsonroids.jspoon.annotation.Selector

data class IntentionsModel(
    @Selector(
        ".content h3, .content p, .content h2",
        attr = "outerHtml"
    ) val textList: List<String> = emptyList(),
)
