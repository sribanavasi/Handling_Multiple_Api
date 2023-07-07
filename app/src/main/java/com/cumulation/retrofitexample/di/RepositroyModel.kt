package com.cumulation.retrofitexample.di

import com.cumulation.retrofitexample.repo.NetworkRepositry
import com.cumulation.retrofitexample.repo.NetworkRepositryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositroyModel {
    @Binds
    @Singleton
    abstract fun networkRepo(repo: NetworkRepositryImp): NetworkRepositry
}