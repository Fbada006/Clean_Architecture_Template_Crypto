package com.droidafricana.domain.models

import com.droidafricana.domain.utils.randomString
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CryptoTest {

    lateinit var cryptoModel: Crypto

    @Test
    fun `instantiate crypto object check proper class and content`() {
        cryptoModel = Crypto(randomString(), randomString(), randomString())

        val copy = cryptoModel.copy()

        assertThat(copy).isEqualTo(cryptoModel)
        assertThat(cryptoModel).isInstanceOf(Crypto::class.java)
    }
}
