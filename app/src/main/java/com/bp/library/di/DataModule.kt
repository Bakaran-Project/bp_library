package com.bp.library.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bp.library.BuildConfig
import com.bp.library.data.SharedPref
import com.bp.library.data.local.BpDatabase
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.resources.Resources
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.gson.gson
import java.util.Locale

/**
 *
 * author Trian Damai
 * created_at 21/03/22 - 12.12
 * site https://trian.app
 */

@Module
@InstallIn(
    value = [
        SingletonComponent::class
    ]
)
object DataModule {
    @Provides
    fun provideDatabase(
        @ApplicationContext appContext:Context
    ):BpDatabase = Room.databaseBuilder(
        appContext,
        BpDatabase::class.java,
        BpDatabase.DB_NAME
    )
        .fallbackToDestructiveMigration()
        .addCallback(object :RoomDatabase.Callback(){

        })
        .build()

    @Provides
    fun provideSharedPref(
        @ApplicationContext appContext: Context
    ): SharedPreferences = appContext.getSharedPreferences(
        BuildConfig.SHARED_PREFERENCES,
        Context.MODE_PRIVATE
    )

    @Provides
    fun provideLocalSession(
        sharedPreferences: SharedPreferences
    ): SharedPref = SharedPref(
        sharedPreferences
    )

    @Provides
    fun provideHttpClient(
        @ApplicationContext appContext: Context,
        sharedPref: SharedPref
    ): HttpClient {
        val chucker = ChuckerInterceptor
            .Builder(appContext)
            .collector(
                ChuckerCollector(
                    context = appContext,
                    showNotification = true,
                    retentionPeriod = RetentionManager.Period.ONE_HOUR
                )
            )
            .maxContentLength(250_000L)
            .redactHeaders(emptySet())
            .alwaysReadResponseBody(false)
            .build()
        val okHttpEngine = OkHttp.create {
            addInterceptor(chucker)
        }
        return HttpClient(okHttpEngine) {
            expectSuccess = true
            install(HttpTimeout) {
                socketTimeoutMillis = 180_000
            }
            install(Resources)
            defaultRequest {
                url(BuildConfig.BASE_URL)
                val locale = sharedPref.getLanguage()
                header("Accept-Language", locale.ifEmpty { Locale.ENGLISH.language })
                contentType(ContentType.Application.Json)
            }
            install(ContentNegotiation) {
                gson {
                    setLenient()
                    setPrettyPrinting()
                }
            }

        }
    }
}