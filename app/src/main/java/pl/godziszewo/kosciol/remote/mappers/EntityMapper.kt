/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/4/23, 7:29 PM
 *
 */

package pl.godziszewo.kosciol.remote.mappers

interface EntityMapper<M, E> {
    fun mapToEntity(model: M): E
}
