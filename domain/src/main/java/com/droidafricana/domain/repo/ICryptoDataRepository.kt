package com.droidafricana.domain.repo

import com.droidafricana.domain.models.Crypto
import kotlinx.coroutines.flow.Flow

interface ICryptoDataRepository {

    suspend fun getCoins(): Flow<List<Crypto>?>
}
