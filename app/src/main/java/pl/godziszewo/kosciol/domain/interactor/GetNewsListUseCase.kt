/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 6/1/23, 9:29 PM
 *
 */

package pl.godziszewo.kosciol.domain.interactor

import kotlinx.coroutines.flow.Flow
import pl.godziszewo.kosciol.domain.models.News
import pl.godziszewo.kosciol.domain.repository.ChurchRepository
import javax.inject.Inject

class GetCharacterListUseCase @Inject constructor(
    private val churchRepository: ChurchRepository
) : BaseUseCase<Unit, Flow<List<News>>> {

    override suspend operator fun invoke(params: Unit) = churchRepository.getNews()
}