package com.droidafricana.data.api

import okhttp3.logging.HttpLoggingInterceptor

object LoggingInterceptor {
    fun create() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
}
