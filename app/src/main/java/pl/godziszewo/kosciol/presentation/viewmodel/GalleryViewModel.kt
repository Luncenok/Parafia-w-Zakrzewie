/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 3/10/23, 9:37 PM
 *
 */

package pl.godziszewo.kosciol.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.godziszewo.kosciol.cache.models.GalleryCacheEntity
import pl.godziszewo.kosciol.data.GalleryInfoRepository
import javax.inject.Inject

@Deprecated("No longer needed")
@HiltViewModel
class GalleryViewModel @Inject constructor(repository: GalleryInfoRepository) : ViewModel() {

    val allGalleryCacheEntity: List<GalleryCacheEntity>

    init {
        allGalleryCacheEntity = repository.allGalleryCacheEntity
    }

}
