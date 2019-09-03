package com.wkswind.server.api.controllers

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.protobuf.ProtoConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object Client {
	val api: Api by lazy {
		val client = OkHttpClient.Builder()
			.build()
		Retrofit.Builder()
			.client(client)
			.addConverterFactory(ProtoConverterFactory.create())
			.addConverterFactory(ScalarsConverterFactory.create())
			.baseUrl(HttpUrl.Builder().scheme("http").host("localhost").port(10086).build())
			.build().create(Api::class.java)
	}
}