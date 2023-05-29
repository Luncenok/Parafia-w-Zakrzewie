/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 5/10/23, 10:00 PM
 *
 */

package pl.godziszewo.kosciol.data.source

import pl.godziszewo.kosciol.data.repository.ChurchCache
import pl.godziszewo.kosciol.data.repository.ChurchDataSource
import javax.inject.Inject

open class ChurchDataSourceFactory @Inject constructor(
    private val churchCache: ChurchCache,
    private val cacheDataSource: ChurchCacheDataSource,
    private val remoteDataSource: ChurchRemoteDataSource
) {
    open suspend fun getDataStore(isCached: Boolean): ChurchDataSource {
        return if (isCached && !churchCache.isExpired()) {
            getCacheDataSource()
        } else {
            getRemoteDataSource()
        }
    }

    fun getRemoteDataSource(): ChurchDataSource {
        return remoteDataSource
    }

    fun getCacheDataSource(): ChurchDataSource {
        return cacheDataSource
    }
}