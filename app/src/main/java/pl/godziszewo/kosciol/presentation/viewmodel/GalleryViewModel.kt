/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/3/23, 9:59 PM
 *
 */

package pl.godziszewo.kosciol.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.godziszewo.kosciol.cache.models.GalleryInfo
import pl.godziszewo.kosciol.data.GalleryInfoRepository
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(repository: GalleryInfoRepository) : ViewModel() {

    val allGalleryInfo: LiveData<List<GalleryInfo>>

    init {
        allGalleryInfo = repository.allGalleryInfo
    }

}
