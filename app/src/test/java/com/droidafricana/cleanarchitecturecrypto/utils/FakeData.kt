package com.droidafricana.cleanarchitecturecrypto.utils

import com.droidafricana.cleanarchitecturecrypto.models.CryptoUiModel

val fakeCryptos = listOf(
    CryptoUiModel(randomString(), randomString(), randomString()),
    CryptoUiModel(randomString(), randomString(), randomString()),
    CryptoUiModel(randomString(), randomString(), randomString()),
    CryptoUiModel(randomString(), randomString(), randomString()),
    CryptoUiModel(randomString(), randomString(), randomString())
)

fun randomString() = java.util.UUID.randomUUID().toString()
