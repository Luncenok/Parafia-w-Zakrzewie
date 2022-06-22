package pl.godziszewo.kosciol.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.godziszewo.kosciol.data.local.AppDatabase
import pl.godziszewo.kosciol.data.local.BibliaDao
import pl.godziszewo.kosciol.data.local.GalleryInfoDao
import pl.godziszewo.kosciol.data.remote.JsoupConverterFactory
import pl.godziszewo.kosciol.repository.BibliaRepository
import pl.godziszewo.kosciol.repository.GalleryInfoRepository
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideHttpInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://parafiawielichowo.pl/")
            .client(okHttpClient)
            .addConverterFactory(JsoupConverterFactory)
            .build()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext app: Context) =
        Room.databaseBuilder(app, AppDatabase::class.java, "app_database").build()

    @Singleton
    @Provides //TODO: Rename this
    fun provideBibliaDao(db: AppDatabase) = db.bibliaDao()

    @Singleton
    @Provides //TODO: Rename this
    fun provideGalleryInfoDao(db: AppDatabase) = db.galleryInfoDao()

    @Singleton
    @Provides
    fun provideGalleryInfoRepository(galleryInfoDao: GalleryInfoDao) =
        GalleryInfoRepository(galleryInfoDao)

    @Singleton
    @Provides
    fun provideBibliaRepository(bibliaDao: BibliaDao) =
        BibliaRepository(bibliaDao)
}