/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 12/23/23, 2:24 PM
 *
 */

package pl.godziszewo.kosciol.remote.models

import pl.droidsonroids.jspoon.annotation.Selector

data class ContactModel(
    @Selector(
        ".contact h3, .contact p",
        attr = "outerHtml"
    ) val textList: List<String> = emptyList()
)
