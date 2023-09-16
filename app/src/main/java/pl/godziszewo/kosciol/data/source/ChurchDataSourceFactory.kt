/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/16/23, 5:15 PM
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
    open suspend fun getNewsDataStore(isCached: Boolean): ChurchDataSource {
        return if (isCached && !churchCache.isNewsExpired()) {
            getCacheDataSource()
        } else {
            getRemoteDataSource()
        }
    }

    open suspend fun getAnnouncementsDataStore(isCached: Boolean): ChurchDataSource {
        return if (isCached && !churchCache.isAnnouncementsExpired()) {
            getCacheDataSource()
        } else {
            getRemoteDataSource()
        }
    }

    open suspend fun getIntentionsDataStore(isCached: Boolean): ChurchDataSource {
        return if (isCached && !churchCache.isIntentionsExpired()) {
            getCacheDataSource()
        } else {
            getRemoteDataSource()
        }
    }

    open suspend fun getCemeteryDataStore(isCached: Boolean): ChurchDataSource {
        return if (isCached && !churchCache.isCemeteryExpired()) {
            getCacheDataSource()
        } else {
            getRemoteDataSource()
        }
    }

    open suspend fun getContactDataStore(isCached: Boolean): ChurchDataSource {
        return if (isCached && !churchCache.isContactExpired()) {
            getCacheDataSource()
        } else {
            getRemoteDataSource()
        }
    }

    open suspend fun getConfessionDataStore(isCached: Boolean): ChurchDataSource {
        return if (isCached && !churchCache.isConfessionExpired()) {
            getCacheDataSource()
        } else {
            getRemoteDataSource()
        }
    }

    open suspend fun getHistoryDataStore(isCached: Boolean): ChurchDataSource {
        return if (isCached && !churchCache.isHistoryExpired()) {
            getCacheDataSource()
        } else {
            getRemoteDataSource()
        }
    }

    open suspend fun getMassesDataStore(isCached: Boolean): ChurchDataSource {
        return if (isCached && !churchCache.isMassesExpired()) {
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