/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 5/8/23, 8:41 PM
 *
 */

package pl.godziszewo.kosciol.cache.mapper

interface CacheMapper<T, V> {

    fun mapFromCached(type: T): V

    fun mapToCached(type: V): T
}
