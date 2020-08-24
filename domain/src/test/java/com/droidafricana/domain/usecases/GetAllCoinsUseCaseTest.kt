package com.droidafricana.domain.usecases

import com.droidafricana.domain.repo.ICryptoDataRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetAllCoinsUseCaseTest {

    @Mock
    private lateinit var iCryptoDataRepository: ICryptoDataRepository

    lateinit var getAllCoinsUseCase: GetAllCoinsUseCase

    @Before
    fun setup() {
        getAllCoinsUseCase = GetAllCoinsUseCase(iCryptoDataRepository)
    }

    @Test
    fun `when request coins get all coins`() {
        runBlocking {
            // Get all coins
            getAllCoinsUseCase()

            // verify that there is data
            Mockito.verify(iCryptoDataRepository).getCoins()
        }
    }
}
