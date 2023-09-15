/*
 * *
 *  * Created by Mateusz Idziejczak on 05.03.2022
 *  * Copyright (c) 2023 . All rights reserved.
 *  * Last modified 9/15/23, 9:48 PM
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

    @GET("ogloszenia-duszpasterskie")
    suspend fun getAnnouncementsUrls(): UrlsModel

    @GET("ogloszenia-duszpasterskie/{url}")
    suspend fun getAnnouncements(@Path("url") url: String): AnnouncementsModel

    @GET("intencje")
    suspend fun getIntentionsUrls(): UrlsModel

    @GET("intencje/{url}")
    suspend fun getIntentions(@Path("url") url: String): IntentionsModel

    @GET("intencje")
    suspend fun getCemetery(): CemeteryModel

    @GET("intencje")
    suspend fun getConfession(): ConfessionModel

    @GET("intencje")
    suspend fun getContact(): ContactModel

    @GET("intencje")
    suspend fun getHistory(): HistoryModel

    @GET("intencje")
    suspend fun getMasses(): MassesModel
}