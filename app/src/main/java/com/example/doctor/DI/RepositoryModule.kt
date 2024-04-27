package com.example.doctor.DI

import com.example.doctor.medication.data.drugInfoApiImpl
import com.example.doctor.medication.domain.model.repository.druginfoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun binddruginfoRepo(impl: drugInfoApiImpl): druginfoRepository
}