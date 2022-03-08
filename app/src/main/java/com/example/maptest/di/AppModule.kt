package com.example.maptest.di

import com.example.maptest.data.PinsRepositoryImpl
import com.example.maptest.domain.PinsRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    companion object {

        @Provides
        @Singleton
        fun provideGson(): Gson = GsonBuilder().create()
    }

    @Binds
    fun bindPinsRepository(pinsRepositoryImpl: PinsRepositoryImpl): PinsRepository
}