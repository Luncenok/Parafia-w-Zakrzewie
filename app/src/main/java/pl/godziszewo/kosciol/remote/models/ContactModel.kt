/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 11:48 PM
 *
 */

package pl.godziszewo.kosciol.remote.models

import pl.droidsonroids.jspoon.annotation.Selector

data class ContactModel(
    @Selector(
        ".contact-address h3, .contact-address p",
        attr = "outerHtml"
    ) val textList: List<String> = emptyList()
)
