package org.d3if0019.daftarhotel.network

import org.d3if0019.daftarhotel.model.Hotel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.d3if0019.daftarhotel.model.OpStatus
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

private const val BASE_URL = "https://unspoken.my.id/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface HotelApiService {
    @GET("api_afta.php")
    suspend fun getHotel(
        @Header("Authorization") userId: String
    ): List<Hotel>

    @Multipart
    @POST("api_afta.php")
    suspend fun postHotel(
        @Header("Authorization") userId: String,
        @Part("namaHotel") namaHotel: RequestBody,
        @Part("handphone") handphone: RequestBody,
        @Part image: MultipartBody.Part
    ): OpStatus

    @DELETE("api_afta.php")
    suspend fun deleteHotel(
        @Header("Authorization") userId: String,
        @Query("id") id: String
    ): OpStatus
}

object HotelApi {
    val service: HotelApiService by lazy {
        retrofit.create(HotelApiService::class.java)
    }

    fun getHotelUrl(imageId: String): String {
        return "${BASE_URL}image.php?id=$imageId"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }