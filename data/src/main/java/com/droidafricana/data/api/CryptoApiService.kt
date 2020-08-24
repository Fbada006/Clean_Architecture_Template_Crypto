package com.droidafricana.data.api

import com.droidafricana.data.models.CryptoResultEntity
import retrofit2.http.GET

interface CryptoApiService {

    @GET("/list")
    suspend fun getAllCoinsData(): CryptoResultEntity
}
