package com.droidafricana.cleanarchitecturecrypto.di

import com.droidafricana.data.api.CryptoApiService
import com.droidafricana.data.repo.CryptoRepository
import com.droidafricana.data.source.CryptoSource
import com.droidafricana.domain.usecases.GetAllCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    fun provideCryptoSource(apiService: CryptoApiService) =
        CryptoSource(apiService)

    @Provides
    fun provideGetAllCoinsUseCase(cryptoRepository: CryptoRepository) =
        GetAllCoinsUseCase(cryptoRepository)
}
