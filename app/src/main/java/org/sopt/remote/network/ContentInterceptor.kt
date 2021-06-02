package org.sopt.remote.network

import okhttp3.Interceptor
import okhttp3.Response

class ContentInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder().addHeader("Content-Type", "application/json")

        return chain.proceed(requestBuilder.build())
    }
}