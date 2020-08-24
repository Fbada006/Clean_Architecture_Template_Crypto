package com.droidafricana.data.utils

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection

class CryptoRequestDispatcher : Dispatcher() {

    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            "/list" -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(getJson("json/crypto_list.json"))
            }
            else -> throw IllegalArgumentException("Unknown Request Path ${request.path}")
        }
    }
}
