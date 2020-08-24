package com.droidafricana.cleanarchitecturecrypto.di

import com.droidafricana.data.repo.CryptoRepository
import com.droidafricana.domain.repo.ICryptoDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppBindingModule {

    @Singleton
    @Binds
    abstract fun provideCryptoRepository(cryptoRepository: CryptoRepository): ICryptoDataRepository
}
