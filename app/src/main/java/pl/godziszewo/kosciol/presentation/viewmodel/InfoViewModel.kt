/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 11:03 PM
 *
 */

package pl.godziszewo.kosciol.presentation.viewmodel

import androidx.lifecycle.LiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import pl.godziszewo.kosciol.domain.interactor.GetAnnouncementsListUseCase
import pl.godziszewo.kosciol.domain.interactor.GetCemeteryInfoUseCase
import pl.godziszewo.kosciol.domain.interactor.GetConfessionInfoUseCase
import pl.godziszewo.kosciol.domain.interactor.GetContactInfoUseCase
import pl.godziszewo.kosciol.domain.interactor.GetHistoryInfoUseCase
import pl.godziszewo.kosciol.domain.interactor.GetIntentionsListUseCase
import pl.godziszewo.kosciol.domain.interactor.GetMassesInfoUseCase
import pl.godziszewo.kosciol.domain.interactor.GetNewsListUseCase
import pl.godziszewo.kosciol.presentation.utils.CoroutineContextProvider
import pl.godziszewo.kosciol.presentation.utils.UiAwareLiveData
import pl.godziszewo.kosciol.presentation.utils.UiAwareModel
import javax.inject.Inject

sealed class InfoUIModel : UiAwareModel() {
    object Loading : InfoUIModel()
    data class Error(var error: String = "") : InfoUIModel()
    data class Success(val data: List<List<String>>) : InfoUIModel()
}

enum class InfoType {
    ANNOUNCEMENTS, CEMETERY, CONFESSION, CONTACT, HISTORY, INTENTIONS, MASSES, NEWS
}

@HiltViewModel
class InfoViewModel @Inject constructor(
    contextProvider: CoroutineContextProvider,
    private val getNewsListUseCase: GetNewsListUseCase,
    private val getAnnouncementsListUseCase: GetAnnouncementsListUseCase,
    private val getIntentionsListUseCase: GetIntentionsListUseCase,
    private val getCemeteryInfoUseCase: GetCemeteryInfoUseCase,
    private val getContactInfoUseCase: GetContactInfoUseCase,
    private val getConfessionInfoUseCase: GetConfessionInfoUseCase,
    private val getHistoryInfoUseCase: GetHistoryInfoUseCase,
    private val getMassesInfoUseCase: GetMassesInfoUseCase,
) : BaseViewModel(contextProvider) {

    private val _infoList = UiAwareLiveData<InfoUIModel>()
    private val infoList: LiveData<InfoUIModel> = _infoList

    fun getInfo(): LiveData<InfoUIModel> {
        return infoList
    }

    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        _infoList.postValue(InfoUIModel.Error(exception.message ?: "Error"))
    }

    fun getInfo(infoType: String) {
        _infoList.postValue(InfoUIModel.Loading)
        launchCoroutineIO {
            when (InfoType.valueOf(infoType.uppercase())) {
                InfoType.ANNOUNCEMENTS -> loadAnnouncements()
                InfoType.CEMETERY -> loadCemeteryInfo()
                InfoType.CONFESSION -> loadConfessionInfo()
                InfoType.CONTACT -> loadContactInfo()
                InfoType.HISTORY -> loadHistoryInfo()
                InfoType.INTENTIONS -> loadIntentions()
                InfoType.MASSES -> loadMassesInfo()
                InfoType.NEWS -> loadNews()
            }
        }
    }

    private suspend fun loadNews() {
        getNewsListUseCase(Unit).collect {
            _infoList.postValue(InfoUIModel.Success(it.map { it.elements }))
        }
    }

    private suspend fun loadAnnouncements() {
        getAnnouncementsListUseCase(Unit).collect {
            _infoList.postValue(InfoUIModel.Success(it.map { it.textList }))
        }
    }

    private suspend fun loadIntentions() {
        getIntentionsListUseCase(Unit).collect {
            _infoList.postValue(InfoUIModel.Success(it.map { it.textList }))
        }
    }

    private suspend fun loadCemeteryInfo() {
        getCemeteryInfoUseCase(Unit).collect {
            _infoList.postValue(InfoUIModel.Success(listOf(it.textList)))
        }
    }

    private suspend fun loadContactInfo() {
        getContactInfoUseCase(Unit).collect {
            _infoList.postValue(InfoUIModel.Success(listOf(it.textList)))
        }
    }

    private suspend fun loadConfessionInfo() {
        getConfessionInfoUseCase(Unit).collect {
            _infoList.postValue(InfoUIModel.Success(listOf(it.textList)))
        }
    }

    private suspend fun loadHistoryInfo() {
        getHistoryInfoUseCase(Unit).collect {
            _infoList.postValue(InfoUIModel.Success(listOf(it.textList)))
        }
    }

    private suspend fun loadMassesInfo() {
        getMassesInfoUseCase(Unit).collect {
            _infoList.postValue(InfoUIModel.Success(listOf(it.textList)))
        }
    }


}
