package com.example.network.di

import com.example.network.dataSource.BreedsDataSource
import com.example.network.dataSource.BreedsDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class NetworkDataSourceModule {

    @Binds
    abstract fun bindBreedsDataSource(breedsDataSourceImpl: BreedsDataSourceImpl): BreedsDataSource
}