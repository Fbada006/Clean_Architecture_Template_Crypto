package com.droidafricana.domain.usecases

import com.droidafricana.domain.repo.ICryptoDataRepository

class GetAllCoinsUseCase(private val iCryptoDataRepository: ICryptoDataRepository) {

    suspend operator fun invoke() = iCryptoDataRepository.getCoins()
}
