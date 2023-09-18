/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/18/23, 3:33 PM
 *
 */

package pl.godziszewo.kosciol.remote.models

import pl.droidsonroids.jspoon.annotation.Selector

data class HistoryModel(
    @Selector(
        "#sacrament4 h3, #sacrament4 p, #sacrament4 li",
        attr = "outerHtml"
    ) val textList1: List<String> = emptyList(),
    @Selector(
        "#sacrament5 h3, #sacrament5 p, #sacrament5 li",
        attr = "outerHtml"
    ) val textList2: List<String> = emptyList(),
    @Selector(
        "#sacrament6 h3, #sacrament6 p, #sacrament6 li",
        attr = "outerHtml"
    ) val textList3: List<String> = emptyList(),
    @Selector(
        "#sacrament7 h3, #sacrament7 p, #sacrament7 li",
        attr = "outerHtml"
    ) val textList4: List<String> = emptyList(),
    @Selector(
        "#sacrament8 h3, #sacrament8 p, #sacrament8 li",
        attr = "outerHtml"
    ) val textList5: List<String> = emptyList(),
    @Selector(
        "#sacrament3 h3, #sacrament3 p, #sacrament3 li",
        attr = "outerHtml"
    ) val textList6: List<String> = emptyList()
)
