package com.example.kocsistemcase.domain.usecase

abstract class BaseUseCase<in Params, out Result> {

    protected abstract suspend fun execute(params: Params): Result

    suspend operator fun invoke(params: Params): Result {
        return try {
            execute(params)
        } catch (e: Exception) {
            throw e
        }
    }

}