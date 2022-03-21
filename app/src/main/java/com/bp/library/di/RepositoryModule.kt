package com.bp.library.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 *
 * author Trian Damai
 * created_at 21/03/22 - 12.12
 * site https://trian.app
 */

@Module
@InstallIn(
    value = [
        SingletonComponent::class
    ]
)
object RepositoryModule {
}