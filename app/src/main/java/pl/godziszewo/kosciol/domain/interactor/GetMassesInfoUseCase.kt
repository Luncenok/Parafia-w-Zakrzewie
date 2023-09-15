/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 8:39 PM
 *
 */

package pl.godziszewo.kosciol.domain.interactor

import kotlinx.coroutines.flow.Flow
import pl.godziszewo.kosciol.domain.models.Masses
import pl.godziszewo.kosciol.domain.repository.ChurchRepository
import javax.inject.Inject

class GetMassesInfoUseCase @Inject constructor(
    private val churchRepository: ChurchRepository
) : BaseUseCase<Unit, Flow<Masses>> {

    override suspend operator fun invoke(params: Unit) = churchRepository.getMasses()
}