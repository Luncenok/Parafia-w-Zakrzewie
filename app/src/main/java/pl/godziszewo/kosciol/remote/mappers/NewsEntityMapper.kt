/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/4/23, 7:29 PM
 *
 */

package pl.godziszewo.kosciol.remote.mappers

import pl.godziszewo.kosciol.data.models.NewsEntity
import pl.godziszewo.kosciol.remote.models.NewsModel

class NewsEntityMapper : EntityMapper<NewsModel, NewsEntity> {

    override fun mapToEntity(model: NewsModel): NewsEntity {
        return NewsEntity(
            title = model.title,
            date = model.textList.first(),
            short = model.textList[1],
            mainImg = model.imgSrcList.first(),
            textList = model.textList.filterIndexed { index, _ -> index != 0 },
            imgUrls = model.imgSrcList,
        )
    }
}