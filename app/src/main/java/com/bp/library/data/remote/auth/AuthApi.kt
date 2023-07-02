/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bp.library.data.remote.auth

import io.ktor.resources.Resource

@Resource("/v1/auth")
class AuthApi {
    @Resource("sign-in-email")
    class SignInWithEmail(val parent: AuthApi = AuthApi())
}