package com.droidafricana.cleanarchitecturecrypto.utils

sealed class UiState

object Loading : UiState()
object Success : UiState()
class Error(val error: Throwable) : UiState()
