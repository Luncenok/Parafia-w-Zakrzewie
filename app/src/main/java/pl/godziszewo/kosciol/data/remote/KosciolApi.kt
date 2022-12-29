/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/29/22, 3:23 PM
 *
 */

package pl.godziszewo.kosciol.data.remote

import pl.godziszewo.kosciol.data.model.Urls
import retrofit2.http.GET

interface KosciolApi {

    @GET("aktualnosci")
    suspend fun getAktualnosciUrls(): Urls

    @GET("ogloszenia-duszpasterskie")
    suspend fun getOgloszeniaUrls(): Urls

    @GET("intencje")
    suspend fun getIntencjeUrls(): Urls
}