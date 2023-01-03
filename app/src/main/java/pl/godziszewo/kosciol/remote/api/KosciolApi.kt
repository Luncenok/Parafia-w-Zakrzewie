/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/3/23, 9:08 PM
 *
 */

package pl.godziszewo.kosciol.remote.api

import pl.godziszewo.kosciol.remote.models.Aktualnosci
import pl.godziszewo.kosciol.remote.models.Ogloszenia
import pl.godziszewo.kosciol.remote.models.Urls
import retrofit2.http.GET
import retrofit2.http.Path

interface KosciolApi {

    @GET("aktualnosci")
    suspend fun getAktualnosciUrls(): Urls

    @GET("aktualnosci/{url}")
    suspend fun getAktualnosci(@Path("url") url: String): Aktualnosci

    @GET("ogloszenia-duszpasterskie")
    suspend fun getOgloszeniaUrls(): Urls

    @GET("ogloszenia-duszpasterskie/{url}")
    suspend fun getOgloszenia(@Path("url") url: String): Ogloszenia

    @GET("intencje")
    suspend fun getIntencjeUrls(): Urls

//    @GET("intencje/{url}")
//    suspend fun getIntencje(@Path("url") url: String): Intencje
}