/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/3/23, 9:08 PM
 *
 */

package pl.godziszewo.kosciol.remote.models

import pl.droidsonroids.jspoon.annotation.Selector

data class Ogloszenia(
    @Selector(".content > * > * > p:not(.btn-group)") val introList: List<String>,
    @Selector(".content li") val ogloszeniaList: List<String>
)
