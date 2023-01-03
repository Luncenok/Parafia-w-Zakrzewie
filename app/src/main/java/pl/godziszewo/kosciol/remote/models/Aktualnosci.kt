/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/3/23, 9:10 PM
 *
 */

package pl.godziszewo.kosciol.remote.models

import pl.droidsonroids.jspoon.annotation.Selector

data class Aktualnosci(
    @Selector(".content p") val textList: List<String>,
    @Selector(value = ".content img", attr = "src") val imgSrcList: List<String>
)
