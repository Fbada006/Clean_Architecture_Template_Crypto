package com.droidafricana.data.mappers

import com.droidafricana.data.models.CryptoEntity
import com.droidafricana.domain.models.Crypto

// TODO Map the whole list
internal fun CryptoEntity.toDomain() = Crypto(
    this.id, this.name, this.symbol
)
