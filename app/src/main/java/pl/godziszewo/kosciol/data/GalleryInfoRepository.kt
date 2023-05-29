/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 3/10/23, 9:37 PM
 *
 */

package pl.godziszewo.kosciol.data

import androidx.lifecycle.LiveData
import pl.godziszewo.kosciol.cache.dao.GalleryDao
import pl.godziszewo.kosciol.cache.models.GalleryCacheEntity
import javax.inject.Inject

class GalleryInfoRepository @Inject constructor(private val galleryDao: GalleryDao) {
    val allGalleryCacheEntity: LiveData<List<GalleryCacheEntity>> = galleryDao.getAll()

    suspend fun insert(galleryCacheEntity: GalleryCacheEntity) {
        galleryDao.insert(galleryCacheEntity)
    }

    suspend fun deleteAll() {
        galleryDao.deleteAll()
    }
}