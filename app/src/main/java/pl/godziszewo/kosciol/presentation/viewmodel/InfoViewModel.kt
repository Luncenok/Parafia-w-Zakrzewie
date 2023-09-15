/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 6:18 PM
 *
 */

package pl.godziszewo.kosciol.presentation.viewmodel

import androidx.lifecycle.LiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import pl.godziszewo.kosciol.domain.interactor.GetNewsListUseCase
import pl.godziszewo.kosciol.domain.models.News
import pl.godziszewo.kosciol.presentation.utils.CoroutineContextProvider
import pl.godziszewo.kosciol.presentation.utils.UiAwareLiveData
import pl.godziszewo.kosciol.presentation.utils.UiAwareModel
import javax.inject.Inject

sealed class InfoUIModel : UiAwareModel() {
    object Loading : InfoUIModel()
    data class Error(var error: String = "") : InfoUIModel()
    data class Success(val data: List<News>) : InfoUIModel()
}

@HiltViewModel
class InfoViewModel @Inject constructor(
    contextProvider: CoroutineContextProvider,
    private val getNewsListUseCase: GetNewsListUseCase
) : BaseViewModel(contextProvider) {

    private val _infoList = UiAwareLiveData<InfoUIModel>()
    private val infoList: LiveData<InfoUIModel> = _infoList

    fun getInfo(): LiveData<InfoUIModel> {
        return infoList
    }

    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        _infoList.postValue(InfoUIModel.Error(exception.message ?: "Error"))
    }

    fun getInfo(type: Boolean) {// todo enum
        _infoList.postValue(InfoUIModel.Loading)
        launchCoroutineIO {
            if (type)
                loadNews()
            else
                loadNews()
        }
    }

    private suspend fun loadNews() {
        getNewsListUseCase(Unit).collect {
            _infoList.postValue(InfoUIModel.Success(it))
        }
    }


}
