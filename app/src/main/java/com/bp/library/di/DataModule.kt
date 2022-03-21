package com.bp.library.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bp.library.data.local.BpDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
object DataModule {
    @Provides
    fun provideDatabase(
        @ApplicationContext appContext:Context
    ):BpDatabase = Room.databaseBuilder(
        appContext,
        BpDatabase::class.java,
        BpDatabase.DB_NAME
    )
        .fallbackToDestructiveMigration()
        .addCallback(object :RoomDatabase.Callback(){

        })
        .build()
}