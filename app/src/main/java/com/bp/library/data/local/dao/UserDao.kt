package com.bp.library.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import com.bp.library.data.local.entity.User

/**
 * author Trian Damai
 * created_at 21/03/22 - 13.41
 * site https://trian.app
 */
@Dao
interface UserDao {
    @Insert
    fun insert(user: User)
}