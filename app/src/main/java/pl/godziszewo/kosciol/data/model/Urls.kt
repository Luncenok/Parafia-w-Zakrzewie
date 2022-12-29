/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/29/22, 3:23 PM
 *
 */

package pl.godziszewo.kosciol.data.model

import pl.droidsonroids.jspoon.annotation.Selector

data class Urls(
    @Selector(
        value = ".content h3 a:not(.page-link), .content h5 a:not(.page-link)",
        attr = "href"
    ) val urlList: List<String>
)
