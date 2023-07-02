package com.bp.library.domain.auth

import com.bp.library.data.common.ResultState
import com.bp.library.data.remote.auth.AuthDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val authDataSource: AuthDataSource
) {
    operator fun invoke(email: String, password: String): Flow<ResultState<Any>> = flow {
        emit(ResultState.Loading)
        val result = authDataSource.signInWithEmail(email,password)
        emit(result)
    }.flowOn(Dispatchers.IO)
}