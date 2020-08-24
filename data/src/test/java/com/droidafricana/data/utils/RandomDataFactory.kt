package com.droidafricana.data.utils

import com.droidafricana.data.models.CryptoEntity

internal fun randomCrypto() =
    CryptoEntity(randomString(), randomString(), randomString())

internal fun randomString() = java.util.UUID.randomUUID().toString()
