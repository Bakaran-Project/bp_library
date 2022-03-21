package com.bp.library.di


import com.bp.library.data.remote.ApiServices
import com.bp.library.data.remote.RemoteDataSource
import com.bp.library.data.remote.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

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
object NetworkModule {
    @Provides
    internal fun httpLoggingInterceptor(
    ):HttpLoggingInterceptor{
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .build()



    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ):Retrofit =Retrofit.Builder()
            .baseUrl("https://bakaranproject.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    fun provideApiServices(
        retrofit: Retrofit
    ):ApiServices = retrofit
        .create(ApiServices::class.java)

    @Provides
    fun provideRemoteDataSource(
        apiServices: ApiServices
    ):RemoteDataSource = RemoteDataSourceImpl(
        apiServices
    )

}