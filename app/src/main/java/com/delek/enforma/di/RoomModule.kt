package com.delek.enforma.di

import android.content.Context
import androidx.room.Room
import com.delek.enforma.data.ExerciseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "exercise_db"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ExerciseDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideExerciseDao(db: ExerciseDatabase) = db.getExerciseDao()

    @Singleton
    @Provides
    fun provideResumeDao(db: ExerciseDatabase) = db.getResumeDao()


}