package com.vladgrushevoy.testindus.builders

import com.vladgrushevoy.testindus.requests.DeezerApiRequests
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.vladgrushevoy.testindus.config.APIConfiguration
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class ServiceBuilder {

    fun buildService(): DeezerApiRequests {
        return Retrofit.Builder()
            .baseUrl(APIConfiguration.BASE_URL)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(
                        KotlinJsonAdapterFactory()
                    ).build()
                )
            )
            .client(okHttpClient.build())
            .build()
            .create(DeezerApiRequests::class.java)
    }

    private val okHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(
            HttpLoggingInterceptor().apply {
                connectTimeout(30, TimeUnit.SECONDS)
                readTimeout(30, TimeUnit.SECONDS)
                level = HttpLoggingInterceptor.Level.BASIC
            }
        )
    }

    companion object {
        private var serviceBuilder: ServiceBuilder? = null

        fun getInstance(): ServiceBuilder {
            if (serviceBuilder == null) {
                serviceBuilder = ServiceBuilder()
            }
            return serviceBuilder!!
        }
    }
}
