/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 5/10/23, 9:15 PM
 *
 */

package pl.godziszewo.kosciol.data.mapper

interface Mapper<E, M> {

    fun mapFromEntity(type: E): M

    fun mapToEntity(type: M): E
}