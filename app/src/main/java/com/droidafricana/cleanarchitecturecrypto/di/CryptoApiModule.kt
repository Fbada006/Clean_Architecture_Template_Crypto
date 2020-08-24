package com.droidafricana.cleanarchitecturecrypto.di

import com.droidafricana.data.api.CryptoApiService
import com.droidafricana.data.api.HttpClient
import com.droidafricana.data.api.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class CryptoApiModule {

    @Provides
    fun provideLoggingInterceptor() = LoggingInterceptor.create()

    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) =
        HttpClient.create(httpLoggingInterceptor)

    @Singleton
    @Provides
    fun provideCryptoApi(retrofit: Retrofit): CryptoApiService =
        retrofit.create(CryptoApiService::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        @Named("baseUrl") baseUrl: String
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Named("baseUrl")
    fun provideBaseUrl(): String = "https://api.coingecko.com/api/v3/coins"
}
