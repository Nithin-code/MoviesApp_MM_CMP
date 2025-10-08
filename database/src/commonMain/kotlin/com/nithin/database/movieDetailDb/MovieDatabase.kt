package com.nithin.database.movieDetailDb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(
    entities = [MovieEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

}

//@Suppress("KotlinNoActualForExpect")
//expect object AppDatabaseConstructor : RoomDatabaseConstructor<MovieDatabase> {
//    override fun initialize(): MovieDatabase
//}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<MovieDatabase>
): MovieDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}