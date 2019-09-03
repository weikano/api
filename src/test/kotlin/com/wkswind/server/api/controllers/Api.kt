package com.wkswind.server.api.controllers

import com.wkswind.server.api.protobuf.http.ClientRequest
import com.wkswind.server.api.protobuf.http.ServerResponse
import retrofit2.Call
import retrofit2.http.*

interface Api {
	@POST("api/diary")
	@FormUrlEncoded
	fun addDiary(@Field("name") name: String, @Field("content") content: String): Call<String>
	
	@GET("api/diary/{id}")
	fun queryDiaryById(@Path("id") id: Int): Call<String>
	
	@POST("auth/phone")
	fun login(@Body request: ClientRequest): Call<ServerResponse>
}