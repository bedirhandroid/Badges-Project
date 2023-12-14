package com.bedirhandroid.badgesproject.usecases.module

import com.bedirhandroid.badgesproject.base.Repository
import com.bedirhandroid.badgesproject.usecases.impl.badge.BadgeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BadgeUseCaseModule {
    @Provides
    fun providesBadgeUseCase(repo: Repository)  = BadgeUseCase(repo)
}