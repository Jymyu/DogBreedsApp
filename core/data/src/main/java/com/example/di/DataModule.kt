package com.example.di

import com.example.data.BreedsRepository
import com.example.data.BreedsRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindBreedsRepository(breedsRepository: BreedsRepositoryImp): BreedsRepository
}