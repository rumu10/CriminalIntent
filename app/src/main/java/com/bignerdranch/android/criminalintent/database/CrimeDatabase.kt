package com.bignerdranch.android.criminalintent.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.bignerdranch.android.criminalintent.Crime

@Database(entities = [Crime::class], version = 4)
@TypeConverters(CrimeTypeConverters::class)
abstract class CrimeDatabase : RoomDatabase() {
    abstract fun crimeDao(): CrimeDao
}

val migration_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE Crime ADD COLUMN suspect TEXT NOT NULL DEFAULT ''"
        )
    }
}

val migration_2_3 = object : Migration(2,3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE Crime ADD COLUMN photoFileName TEXT"
        )
    }
}

val migration_3_4 = object : Migration(3, 4) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Add SQL statements to modify the schema here
        database.execSQL(
            "ALTER TABLE Crime ADD COLUMN photoFileName1 TEXT"
        )
        database.execSQL(
            "ALTER TABLE Crime ADD COLUMN photoFileName2 TEXT"
        )
        database.execSQL(
            "ALTER TABLE Crime ADD COLUMN photoFileName3 TEXT"
        )
        database.execSQL(
            "ALTER TABLE Crime ADD COLUMN photoFileName4 TEXT"
        )
    }
}