package com.droidafricana.domain.usecases

import com.droidafricana.domain.repo.CryptoRepository

class GetAllCoinsUseCase(private val cryptoRepository: CryptoRepository) {

    suspend operator fun invoke() = cryptoRepository.getAllCoins()
}
