/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 1/4/23, 7:06 PM
 *
 */

package pl.godziszewo.kosciol.remote.api

import pl.godziszewo.kosciol.remote.models.AktualnosciModel
import pl.godziszewo.kosciol.remote.models.OgloszeniaModel
import pl.godziszewo.kosciol.remote.models.UrlsModel
import retrofit2.http.GET
import retrofit2.http.Path

interface KosciolApi {

    @GET("aktualnosci")
    suspend fun getAktualnosciUrls(): UrlsModel

    @GET("aktualnosci/{url}")
    suspend fun getAktualnosci(@Path("url") url: String): AktualnosciModel

    @GET("ogloszenia-duszpasterskie")
    suspend fun getOgloszeniaUrls(): UrlsModel

    @GET("ogloszenia-duszpasterskie/{url}")
    suspend fun getOgloszenia(@Path("url") url: String): OgloszeniaModel

    @GET("intencje")
    suspend fun getIntencjeUrls(): UrlsModel

//    @GET("intencje/{url}")
//    suspend fun getIntencje(@Path("url") url: String): Intencje
}