/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 6:18 PM
 *
 */

package pl.godziszewo.kosciol.remote.mappers

import pl.godziszewo.kosciol.data.models.NewsEntity
import pl.godziszewo.kosciol.remote.models.NewsModel
import javax.inject.Inject

class NewsEntityMapper @Inject constructor() : EntityMapper<NewsModel, NewsEntity> {

    override fun mapToEntity(model: NewsModel): NewsEntity {
        return NewsEntity(
            title = model.textList[0],
            date = model.textList[1],
            short = model.textList[2],
            mainImg = model.imgSrcList.first(),
            textList = model.textList,
            imgUrls = model.imgSrcList,
        )
    }
}