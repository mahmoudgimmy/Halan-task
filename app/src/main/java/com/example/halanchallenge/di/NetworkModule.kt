package com.example.halanchallenge.di

import com.example.halanchallenge.data.remote.AuthenticationInterceptor
import com.example.halanchallenge.data.remote.HalanRemote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL: String = "https://assessment-sn12.halan.io/"

// network module used for providing dependencies for calling apis, di used by koin
val networkModule = module {
    factory { AuthenticationInterceptor(get()) }
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    factory { provideOkHttpClient(get(), get()) }
    factory { provideRetrofit(get()) }
    factory { provideRemoteStoreService(get()) }

}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(
    httpInterceptor: HttpLoggingInterceptor,
    authInterceptor: AuthenticationInterceptor,
): OkHttpClient {

    return OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .addInterceptor(httpInterceptor).build()
}

fun provideRemoteStoreService(retrofit: Retrofit): HalanRemote =
    retrofit.create(HalanRemote::class.java)


