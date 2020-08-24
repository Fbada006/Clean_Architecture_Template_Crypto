package com.droidafricana.data.source

import com.droidafricana.data.BaseTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CryptoSourceTest : BaseTest() {

    private lateinit var cryptoSource: CryptoSource

    @Before
    override fun setup() {
        super.setup()
        cryptoSource = CryptoSource(apiService)
    }

    @Test
    fun `when get list return a valid list with data`() {
        runBlocking {
            val response = cryptoSource.getAllCoins()

            response.collect {
                assertThat(it!!.size).isEqualTo(5)
                assertThat(it[0].name).isEqualTo("0.5X Long Algorand Token")
                assertThat(it[0].symbol).isEqualTo("algohalf")
            }
        }
    }
}
