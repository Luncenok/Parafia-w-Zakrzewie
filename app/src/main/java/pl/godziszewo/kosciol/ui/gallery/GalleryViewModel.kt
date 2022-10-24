/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 10/24/22, 6:30 PM
 *
 */

package pl.godziszewo.kosciol.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.godziszewo.kosciol.data.model.GalleryInfo
import pl.godziszewo.kosciol.repository.GalleryInfoRepository
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(repository: GalleryInfoRepository) : ViewModel() {

    val allGalleryInfo: LiveData<List<GalleryInfo>>

    init {
        allGalleryInfo = repository.allGalleryInfo
    }

}
