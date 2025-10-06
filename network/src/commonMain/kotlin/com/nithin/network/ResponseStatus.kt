package com.nithin.network

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

suspend inline fun<reified T> getResponse(response : HttpResponse) : T?{

    return when(response.status.value){
        in 200..299 -> {
            response.body<T>()
        }

        in 400..499 ->{
            null
        }

        else -> null
    }

}