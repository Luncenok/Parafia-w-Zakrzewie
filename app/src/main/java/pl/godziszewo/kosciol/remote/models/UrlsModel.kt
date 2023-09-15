/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 6:18 PM
 *
 */

package pl.godziszewo.kosciol.remote.models

import pl.droidsonroids.jspoon.annotation.Selector

data class UrlsModel(
    @Selector(
        value = ".content h3 a:not(.page-link), .content h5 a:not(.page-link)",
        attr = "href"
    ) val urlList: List<String> = emptyList()
)
