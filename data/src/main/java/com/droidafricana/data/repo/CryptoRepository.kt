package com.droidafricana.data.repo

import com.droidafricana.data.mappers.toDomain
import com.droidafricana.data.source.CryptoSource
import com.droidafricana.domain.models.Crypto
import com.droidafricana.domain.repo.ICryptoDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CryptoRepository(private val cryptoSource: CryptoSource) : ICryptoDataRepository {

    override suspend fun getCoins(): Flow<List<Crypto>> {
        return cryptoSource.getAllCoins().map { cryptoList ->
            cryptoList.map { it.toDomain() }
        }
    }
}
