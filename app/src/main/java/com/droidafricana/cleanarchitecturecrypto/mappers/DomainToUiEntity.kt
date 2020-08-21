package com.droidafricana.cleanarchitecturecrypto.mappers

import com.droidafricana.cleanarchitecturecrypto.models.CryptoUiModel
import com.droidafricana.domain.models.Crypto

internal fun Crypto.toUiModel() =
    CryptoUiModel(
        this.id,
        this.name,
        this.symbol
    )
