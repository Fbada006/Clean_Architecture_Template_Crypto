package com.droidafricana.cleanarchitecturecrypto.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler

open class UiViewModel : ViewModel() {

    val uiState: LiveData<UiState>
        get() = _uiState

    protected var _uiState = MutableLiveData<UiState>()

    protected val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        _uiState.value = Error(exception)
    }
}
