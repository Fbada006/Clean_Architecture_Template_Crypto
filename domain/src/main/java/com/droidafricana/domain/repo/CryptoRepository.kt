package com.droidafricana.domain.repo

class CryptoRepository(private val cryptoDataSource: CryptoDataSource) {

    suspend fun getAllCoins() = cryptoDataSource.getCoins()
}
