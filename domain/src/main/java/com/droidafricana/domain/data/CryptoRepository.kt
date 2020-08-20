package com.droidafricana.domain.data

class CryptoRepository(private val cryptoDataSource: CryptoDataSource) {

    suspend fun getAllCoins() = cryptoDataSource.getCoins()
}
