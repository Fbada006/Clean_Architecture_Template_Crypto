package com.droidafricana.domain.usecases

import com.droidafricana.domain.repo.ICryptoDataRepository
import javax.inject.Inject

class GetAllCoinsUseCase @Inject constructor(private val iCryptoDataRepository: ICryptoDataRepository) {

    suspend operator fun invoke() = iCryptoDataRepository.getCoins()
}
