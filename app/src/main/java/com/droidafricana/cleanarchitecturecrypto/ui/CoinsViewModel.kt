package com.droidafricana.cleanarchitecturecrypto.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.droidafricana.cleanarchitecturecrypto.mappers.toUiModel
import com.droidafricana.cleanarchitecturecrypto.models.CryptoUiModel
import com.droidafricana.cleanarchitecturecrypto.utils.Loading
import com.droidafricana.cleanarchitecturecrypto.utils.Success
import com.droidafricana.cleanarchitecturecrypto.utils.UiViewModel
import com.droidafricana.domain.usecases.GetAllCoinsUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CoinsViewModel @ViewModelInject constructor(
    private val getAllCoinsUseCase: GetAllCoinsUseCase
) : UiViewModel() {

    private var _cryptoList = MutableLiveData<List<CryptoUiModel>>()

    val cryptoList: LiveData<List<CryptoUiModel>>
        get() = _cryptoList

    fun getAllCoins() {
        _uiState.value = Loading
        viewModelScope.launch(exceptionHandler) {
            getAllCoinsUseCase().collect {
                _cryptoList.value = it?.map { crypto ->
                    crypto.toUiModel()
                }
                _uiState.value = Success
            }
        }
    }
}
