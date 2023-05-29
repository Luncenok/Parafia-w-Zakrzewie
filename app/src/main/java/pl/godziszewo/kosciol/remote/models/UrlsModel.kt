/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/4/23, 7:06 PM
 *
 */

package pl.godziszewo.kosciol.remote.models

import pl.droidsonroids.jspoon.annotation.Selector

data class UrlsModel(
    // TODO: add thse below
//    val titles: List<String>,
//    val shorts: List<String>,
//    val mainImages: List<String>,
    @Selector(
        value = ".content h3 a:not(.page-link), .content h5 a:not(.page-link)",
        attr = "href"
    ) val urlList: List<String>
)
