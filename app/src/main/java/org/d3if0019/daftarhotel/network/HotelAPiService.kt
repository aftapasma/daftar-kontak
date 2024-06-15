package org.d3if0019.daftarhotel.network

import org.d3if0019.daftarhotel.model.Hotel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/" +
        "indraazimi/mobpro1-compose/static-api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface HotelApiService {
    @GET("static-api.json")
    suspend fun getHotel(): List<Hotel>
}

object HotelApi {
    val service: HotelApiService by lazy {
        retrofit.create(HotelApiService::class.java)
    }

    fun getHotelUrl(imageId: String): String {
        return "$BASE_URL$imageId.jpg"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }