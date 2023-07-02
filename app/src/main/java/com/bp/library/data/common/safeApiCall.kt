/*
 * Copyright © 2023 trian.app.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bp.library.data.common

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

suspend inline fun <reified T> safeApiCall(call: () -> HttpResponse): ResultState<T> {
    return try {
        val response = call.invoke()
        if (response.status.value in 200..209) {
            val data = response.body<BaseResponse<T>>()
            ResultState.Result(data.data)
        } else {
            val data = response.body<BaseResponse<List<Any>>>()
            ResultState.Error(data.message, data.code)
        }
    }catch (e:Exception){
        ResultState.Error(e.message.orEmpty())
    }
}

suspend inline fun <reified T> safeApiCall(
    onSaveToken: (token: String) -> Unit = {},
    call: () -> HttpResponse
): ResultState<T> {
    return try {
        val response = call.invoke()
        if (response.status.value in 200..209) {
            val data = response.body<BaseResponse<T>>()
            if (data.token.isNotEmpty()) {
                onSaveToken(data.token)
            }
            ResultState.Result(data.data)
        } else {
            val data = response.body<BaseResponse<List<Any>>>()
            ResultState.Error(data.message, data.code)
        }
    } catch (e:Exception){
        ResultState.Error(e.message.orEmpty())
    }
}
