/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/29/22, 3:23 PM
 *
 */

package pl.godziszewo.kosciol.data.model

import pl.droidsonroids.jspoon.annotation.Selector

data class Aktualnosci(
    @Selector(".content p") val textList: List<String>,
    @Selector(value = ".content img", attr = "src") val imgSrcList: List<String>
)
