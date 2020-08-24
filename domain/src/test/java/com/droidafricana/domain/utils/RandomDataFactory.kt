package com.droidafricana.domain.utils

import com.droidafricana.domain.models.Crypto
import java.util.UUID.randomUUID

fun randomString() = randomUUID().toString()

fun randomCrypto() = Crypto(randomString(), randomString(), randomString())
