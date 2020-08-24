package com.droidafricana.data.api

import com.droidafricana.data.models.CryptoEntity
import retrofit2.http.GET

interface CryptoApiService {

    @GET("list")
    suspend fun getAllCoinsData(): List<CryptoEntity>
}
