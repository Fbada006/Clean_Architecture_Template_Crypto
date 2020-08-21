package com.droidafricana.domain.repo

import com.droidafricana.domain.models.CryptoResult
import kotlinx.coroutines.flow.Flow

interface CryptoDataSource {

    suspend fun getCoins(): Flow<CryptoResult>
}
