package com.nithin.database.movieDetailDb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert


@Dao
interface MovieDao {

    @Upsert
    suspend fun upsert(movieEntity: MovieEntity)

    @Delete
    suspend fun delete(movieEntity: MovieEntity)

    @Query("SELECT EXISTS(SELECT 1 FROM MovieEntity WHERE id = :id)")
    suspend fun isBookMarked(id : String) : Boolean



}