package com.droidafricana.data.models

import com.droidafricana.data.utils.randomCrypto
import com.google.common.truth.Truth
import org.junit.Test

class CryptoEntityTest {

    lateinit var cryptoModel: CryptoEntity

    @Test
    fun `instantiate crypto object check proper class and content`() {
        cryptoModel = randomCrypto()

        val copy = cryptoModel.copy()

        Truth.assertThat(copy).isEqualTo(cryptoModel)
        Truth.assertThat(cryptoModel).isInstanceOf(CryptoEntity::class.java)
    }
}
