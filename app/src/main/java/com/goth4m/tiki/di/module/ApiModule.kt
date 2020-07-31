package com.goth4m.tiki.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.goth4m.tiki.BuildConfig
import com.goth4m.tiki.network.api.HomeApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { provideGson() }
    single { provideOkhttpClient() }
    single { provideRetrofit(get(), get()) }
    factory { provideHomeApi(get()) }
}

fun provideGson(): Gson {
    val gsonBuilder = GsonBuilder()
    return gsonBuilder.create()
}

internal fun provideOkhttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    if (BuildConfig.DEBUG)
        interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor).build()

    client.newBuilder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()
    return client
}

internal fun provideRetrofit(
    gson: Gson,
    okHttpClient: OkHttpClient
): Retrofit {
    return Retrofit.Builder()
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl("https://api.tiki.vn/")
        .client(okHttpClient)
        .build()
}

internal fun provideHomeApi(retrofit: Retrofit): HomeApi {
    return retrofit.create(HomeApi::class.java)
}
