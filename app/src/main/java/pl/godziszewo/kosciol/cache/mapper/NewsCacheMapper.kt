/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 5/10/23, 8:06 PM
 *
 */

package pl.godziszewo.kosciol.cache.mapper

import pl.godziszewo.kosciol.cache.models.NewsCacheEntity
import pl.godziszewo.kosciol.data.models.NewsEntity
import javax.inject.Inject

class NewsCacheMapper @Inject constructor() : CacheMapper<NewsCacheEntity, NewsEntity> {
    override fun mapFromCached(type: NewsCacheEntity): NewsEntity {
        return NewsEntity(
            title = type.title,
            date = type.date,
            short = type.short,
            mainImg = type.mainImg,
            textList = type.elements ?: emptyList(),
            imgUrls = type.images ?: emptyList()
        )
    }

    override fun mapToCached(type: NewsEntity): NewsCacheEntity {
        return NewsCacheEntity(
            title = type.title,
            date = type.date,
            short = type.short,
            mainImg = type.mainImg,
            elements = type.textList.ifEmpty { null },
            images = type.imgUrls.ifEmpty { null }
        )

    }
}