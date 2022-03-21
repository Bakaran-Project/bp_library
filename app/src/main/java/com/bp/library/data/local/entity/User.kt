package com.bp.library.data.local.entity

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * author Trian Damai
 * created_at 21/03/22 - 13.40
 * site https://trian.app
 */
@Keep
@Entity
data class User(
    @PrimaryKey
    var id:String
)
