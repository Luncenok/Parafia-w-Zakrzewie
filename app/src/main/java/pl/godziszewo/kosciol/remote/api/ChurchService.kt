/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 12/23/23, 2:05 PM
 *
 */

package pl.godziszewo.kosciol.remote.api

import pl.godziszewo.kosciol.remote.models.AnnouncementsModel
import pl.godziszewo.kosciol.remote.models.CemeteryModel
import pl.godziszewo.kosciol.remote.models.ConfessionModel
import pl.godziszewo.kosciol.remote.models.ContactModel
import pl.godziszewo.kosciol.remote.models.HistoryModel
import pl.godziszewo.kosciol.remote.models.IntentionsModel
import pl.godziszewo.kosciol.remote.models.MassesModel
import pl.godziszewo.kosciol.remote.models.NewsModel
import pl.godziszewo.kosciol.remote.models.UrlsModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ChurchService {

    @GET("aktualnosci")
    suspend fun getNewsUrls(): UrlsModel

    @GET("aktualnosci/{url}")
    suspend fun getNews(@Path("url") url: String): NewsModel

//    @GET("ogloszenia_duszpasterskie")
//    suspend fun getAnnouncementsUrls(): UrlsModel

    @GET("ogloszenia_duszpasterskie")
    suspend fun getAnnouncements(): AnnouncementsModel

//    @GET("intencje")
//    suspend fun getIntentionsUrls(): UrlsModel

    @GET("intencje")
    suspend fun getIntentions(): IntentionsModel

    @GET("cmentarz")
    suspend fun getCemetery(): CemeteryModel

    @GET("sakramenty")
    suspend fun getConfession(): ConfessionModel

    @GET("kontakt")
    suspend fun getContact(): ContactModel

    @GET("sakramenty")
    suspend fun getHistory(): HistoryModel

    @GET("sakramenty")
    suspend fun getMasses(): MassesModel
}