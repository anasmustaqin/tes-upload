package com.example.projectbaruapi

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import java.sql.RowId

object NetworkConfig {
    fun getInterceptor () : OkHttpClient{
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
    return okHttpClient
}

//Retrofit
fun getRetrofit(): Retrofit {
    return Retrofit.Builder()
            .baseUrl("http://10.0.2.2/server_api/index.php/ServerApi/")
        .client(getInterceptor())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
fun getService() = getRetrofit().create(StaffService::class.java)
    }

interface StaffService {
    //Fungsi Create Data
    @FormUrlEncoded
    @POST("addStaff")
    fun addStaff(@Field("name") staff_name : String,
                @Field("hp") staff_hp : String,
                 @Field("alamat") staff_alamat : String) : Call<ResultStatus>

    //Fungsi Get Data
    @GET("getDataStaff")
    fun getData() : Call<ResultStaff>

    //Fungsi Update Data
 @FormUrlEncoded
@POST("updateStaff")
fun updateStaff(@Field("id") staff_id: String,
                    @Field("name") staff_name: String,
                    @Field("hp") staff_hp: String,
                    @Field("alamat") staff_alamat : String) : Call<ResultStatus>


    //Fungsi Delete Data
    @FormUrlEncoded
    @POST("deleteStaff")
    fun deleteStaff(@Field("id") string_id: String?) : Call<ResultStatus>

}

