package com.bp.library.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bp.library.data.local.dao.UserDao
import com.bp.library.data.local.entity.User

/**
 * author Trian Damai
 * created_at 21/03/22 - 13.39
 * site https://trian.app
 */

@Database(
    entities = [
        User::class
    ],
    version = 1,
    exportSchema = true
)
abstract class BpDatabase:RoomDatabase() {
    abstract fun userDao():UserDao
    companion object{
        const val DB_NAME = "BP"
    }
}