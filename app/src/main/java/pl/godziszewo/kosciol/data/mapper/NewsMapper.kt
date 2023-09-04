/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 6/2/23, 3:44 PM
 *
 */

package pl.godziszewo.kosciol.data.mapper

import pl.godziszewo.kosciol.data.models.NewsEntity
import pl.godziszewo.kosciol.domain.models.News
import javax.inject.Inject

class NewsMapper @Inject constructor() : Mapper<NewsEntity, News> {
    override fun mapFromEntity(type: NewsEntity): News { // todo text -> html
        return News(
            id = type.id ?: 0,
            title = type.title,
            date = type.date,
            short = type.short,
            mainImg = type.mainImg,
            elements = type.textList,
            images = type.imgUrls
        )
    }

    override fun mapToEntity(type: News): NewsEntity { // todo html -> text
        return NewsEntity(
            id = type.id,
            title = type.title,
            date = type.date,
            short = type.short,
            mainImg = type.mainImg,
            textList = type.elements,
            imgUrls = type.images
        )
    }
}