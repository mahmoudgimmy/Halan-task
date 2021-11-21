package com.example.halanchallenge.di

import com.example.halanchallenge.remote.HalanRemote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL: String = "https://assessment-sn12.halan.io/"

// network module used for providing dependencies for calling apis, di used by koin
val networkModule = module {
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    single { provideRemoteStoreService(get()) }

}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(
    httpInterceptor: HttpLoggingInterceptor
): OkHttpClient {

    return OkHttpClient().newBuilder()
        .addInterceptor(httpInterceptor).build()
}

fun provideRemoteStoreService(retrofit: Retrofit): HalanRemote = retrofit.create(HalanRemote::class.java)


