package com.nithin.network

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

actual fun getHttpClient(): HttpClientEngine {
    return OkHttp.create()
}