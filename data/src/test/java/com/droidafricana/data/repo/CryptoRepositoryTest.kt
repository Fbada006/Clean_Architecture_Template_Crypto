package com.droidafricana.data.repo

import com.droidafricana.data.BaseTest
import com.droidafricana.data.source.CryptoSource
import com.droidafricana.domain.repo.ICryptoDataRepository
import com.google.common.truth.Truth
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CryptoRepositoryTest : BaseTest() {

    private lateinit var iCryptoDataRepository: ICryptoDataRepository

    @Before
    override fun setup() {
        super.setup()
        val mockCyrptoSource = CryptoSource(apiService)
        iCryptoDataRepository = CryptoRepository(mockCyrptoSource)
    }

    @Test
    fun `when get list return a valid list with data`() {
        runBlocking {
            val response = iCryptoDataRepository.getCoins()

            response.collect {
                Truth.assertThat(it!!.size).isEqualTo(5)
                Truth.assertThat(it[0].name).isEqualTo("0.5X Long Algorand Token")
                Truth.assertThat(it[0].symbol).isEqualTo("algohalf")
            }
        }
    }
}
