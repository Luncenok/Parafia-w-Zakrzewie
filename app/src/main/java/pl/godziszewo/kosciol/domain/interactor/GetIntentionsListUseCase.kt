/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 12/23/23, 2:05 PM
 *
 */

package pl.godziszewo.kosciol.domain.interactor

import kotlinx.coroutines.flow.Flow
import pl.godziszewo.kosciol.domain.models.Intention
import pl.godziszewo.kosciol.domain.repository.ChurchRepository
import javax.inject.Inject

class GetIntentionsListUseCase @Inject constructor(
    private val churchRepository: ChurchRepository
) : BaseUseCase<Unit, Flow<Intention>> {

    override suspend operator fun invoke(params: Unit) = churchRepository.getIntentions()
}