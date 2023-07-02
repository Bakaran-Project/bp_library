/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bp.library.data.remote.auth

import com.bp.library.data.SharedPref
import com.bp.library.data.common.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.plugins.resources.post
import io.ktor.client.request.setBody
import javax.inject.Inject

class AuthDataSource @Inject constructor(
    private val httpClient: HttpClient,
    private val pref: SharedPref
) {
    suspend fun signInWithEmail(
        email: String,
        password: String
    ) = safeApiCall<Any>() {
        httpClient.post(AuthApi.SignInWithEmail()) {
            setBody(
                mapOf(
                    "email" to email,
                    "password" to password
                )
            )
        }
    }
}