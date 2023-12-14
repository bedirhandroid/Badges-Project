package com.bedirhandroid.badgesproject.usecases.module

import com.bedirhandroid.badgesproject.base.Repository
import com.bedirhandroid.badgesproject.usecases.impl.praise.PraiseUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PraiseUseCaseModule {
    @Provides
    fun providesPraiseUseCase(repo : Repository) = PraiseUseCase(repo)
}