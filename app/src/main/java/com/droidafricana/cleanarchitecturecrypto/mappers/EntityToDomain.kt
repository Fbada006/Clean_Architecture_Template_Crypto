package com.droidafricana.cleanarchitecturecrypto.mappers

import com.droidafricana.cleanarchitecturecrypto.models.CryptoUiModel
import com.droidafricana.domain.models.Crypto

fun CryptoUiModel.toDomain() = Crypto(
    id = this.id,
    name = this.name,
    symbol = this.symbol
)
