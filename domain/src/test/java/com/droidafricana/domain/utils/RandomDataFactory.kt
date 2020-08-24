package com.droidafricana.domain.utils

import com.droidafricana.domain.models.Crypto
import java.util.UUID.randomUUID

internal fun randomString() = randomUUID().toString()

internal fun randomCrypto() = Crypto(randomString(), randomString(), randomString())
