/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bp.library.data.common

import androidx.annotation.RawRes

sealed class ResultState<out R> {
    object Loading : ResultState<Nothing>()
    data class Result<out Result>(val data: Result) : ResultState<Result>()
    data class Error(
        val message: String = "",
        @RawRes val stringId: Int = 0
    ) : ResultState<Nothing>()

}