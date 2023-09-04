/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 6/2/23, 3:53 PM
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
            textList = type.elements?.split() ?: emptyList(),
            imgUrls = type.images?.split() ?: emptyList()
        )
    }

    override fun mapToCached(type: NewsEntity): NewsCacheEntity {
        return NewsCacheEntity(
            title = type.title,
            date = type.date,
            short = type.short,
            mainImg = type.mainImg,
            elements = type.textList.ifEmpty { null }?.join(),
            images = type.imgUrls.ifEmpty { null }?.join()
        )

    }
}