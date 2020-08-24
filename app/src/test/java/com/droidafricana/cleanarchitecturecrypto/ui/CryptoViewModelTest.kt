package com.droidafricana.cleanarchitecturecrypto.ui

import com.droidafricana.cleanarchitecturecrypto.BaseViewModelTest
import com.droidafricana.cleanarchitecturecrypto.mappers.toDomain
import com.droidafricana.cleanarchitecturecrypto.utils.fakeCryptos
import com.droidafricana.cleanarchitecturecrypto.utils.observeOnce
import com.droidafricana.domain.usecases.GetAllCoinsUseCase
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CryptoViewModelTest : BaseViewModelTest() {

    @Mock
    lateinit var getAllCoinsUseCase: GetAllCoinsUseCase

    private lateinit var cryptoViewModel: CryptoViewModel

    @Before
    fun setup() {
        cryptoViewModel = CryptoViewModel(getAllCoinsUseCase)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `call to api should return crypto list`() {
        runBlockingTest {
            given(getAllCoinsUseCase()).willReturn(flow {
                emit(fakeCryptos.map {
                    it.toDomain()
                })
            })

            cryptoViewModel.getAllCoins()

            cryptoViewModel.cryptoList.observeOnce {
                Truth.assertThat(it).isEqualTo(fakeCryptos)
            }
        }
    }
}
