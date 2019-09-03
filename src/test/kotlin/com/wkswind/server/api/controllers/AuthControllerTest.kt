package com.wkswind.server.api.controllers

import com.google.protobuf.ByteString
import com.google.protobuf.util.JsonFormat
import com.wkswind.server.api.protobuf.http.*
import okhttp3.Callback
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception

internal class AuthControllerTest {
	
	@Test
	fun login() {
		val device = Device.newBuilder()
			.setBrand("brand").setChannel("channel").setModel("model").setOs("4.4")
			.setVersionCode(19).build()
		val header = Header.newBuilder().setAccount("account").setAppId("appId")
			.setDevice(device).setPlatform(Platform.ANDROID).setRefreshToken("refreshToken")
			.setToken("token").putExt("key", "value")
			.build()
		val request = ClientRequest.newBuilder()
			.setBody(ByteString.copyFrom("fromClient".toByteArray(Charsets.UTF_8)))
			.setHeader(header)
			.build();
		try {
			val response = Client.api.login(request).execute().body()
			println(JsonFormat.printer().print(response))
			println(response?.body?.toString(Charsets.UTF_8))
		} catch (e: Exception) {
			e.printStackTrace()
		}
	}
}