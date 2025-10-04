package com.nithin.shared.utils

sealed interface RequestState<out T> {


    data object Idle : RequestState<Nothing>

    data object Loading : RequestState<Nothing>

    data class Success<out T>(val data : T) : RequestState<T>

    data class Error(val message : String) : RequestState<Nothing>

    fun isLoading() = this is RequestState.Loading

    fun isIdle() = this is RequestState.Idle

    fun isSuccess() = this is RequestState.Success

    fun isError() = this is Error


    fun getSuccessData() = (this as Success).data

    fun getSuccessDataOrNull() = if (this.isSuccess()) getSuccessData() else null

    fun getErrorMessage() = (this as Error).message


}