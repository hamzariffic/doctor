package com.example.doctor.DI

import com.example.doctor.Util.Constant.BASE_URL
import com.example.doctor.Util.Constant.X_RAPIDAPI_KEY
import com.example.doctor.medication.data.drugInfoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton

    fun providesDruginfoApi(): drugInfoApi {
        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("X-RapidAPI-Key", X_RAPIDAPI_KEY)
                    .build()
                chain.proceed(request)
            }
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(drugInfoApi::class.java)
    }
//    We can provide the drugApi in the app module or in the repository module
}