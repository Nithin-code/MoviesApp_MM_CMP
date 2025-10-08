package com.nithin.database.movieDetailDb

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "MovieEntity")
data class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val createdAt: Long,
    val title: String,
    val genre: List<String>,
    val rating: Float,
    val release_date: Long,
    val poster_url: String,
    val duration_minutes: Int,
    val director: String,
    val cast: List<String>,
    val box_office_usd: Long,
    val description: String
)

