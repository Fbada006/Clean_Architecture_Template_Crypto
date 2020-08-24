package com.droidafricana.data

import com.droidafricana.data.api.CryptoApiService
import com.droidafricana.data.api.HttpClient
import com.droidafricana.data.api.LoggingInterceptor
import com.droidafricana.data.api.MoshiCreator
import com.droidafricana.data.utils.CryptoRequestDispatcher
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

open class BaseTest {

    lateinit var mockWebServer: MockWebServer

    private lateinit var okHttpClient: OkHttpClient

    private lateinit var loggingInterceptor: HttpLoggingInterceptor

    private lateinit var moshi: Moshi

    lateinit var apiService: CryptoApiService

    @Before
    open fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher =
            CryptoRequestDispatcher()
        mockWebServer.start()
        loggingInterceptor = LoggingInterceptor.create()
        okHttpClient = HttpClient.create(loggingInterceptor)
        moshi = MoshiCreator.create()

        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(CryptoApiService::class.java)
    }

    @After
    open fun tearDown() {
        mockWebServer.shutdown()
    }
}
