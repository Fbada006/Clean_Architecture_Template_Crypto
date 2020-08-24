package com.droidafricana.data.source

import com.droidafricana.data.api.CryptoApiService
import com.droidafricana.data.models.CryptoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CryptoSource @Inject constructor(private val apiService: CryptoApiService) {

    suspend fun getAllCoins(): Flow<List<CryptoEntity>?> {
        val response = apiService.getAllCoinsData()
        return flow { emit(response) }
    }
}
