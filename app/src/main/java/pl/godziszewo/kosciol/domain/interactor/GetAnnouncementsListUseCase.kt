/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 8:36 PM
 *
 */

package pl.godziszewo.kosciol.domain.interactor

import kotlinx.coroutines.flow.Flow
import pl.godziszewo.kosciol.domain.models.Announcement
import pl.godziszewo.kosciol.domain.repository.ChurchRepository
import javax.inject.Inject

class GetAnnouncementsListUseCase @Inject constructor(
    private val churchRepository: ChurchRepository
) : BaseUseCase<Unit, Flow<List<Announcement>>> {

    override suspend operator fun invoke(params: Unit) = churchRepository.getAnnouncements()
}