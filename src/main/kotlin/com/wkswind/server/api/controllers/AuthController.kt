package com.wkswind.server.api.controllers

import com.google.protobuf.ByteString
import com.google.protobuf.util.JsonFormat
import com.wkswind.server.api.MEDIA_TYPE_PROTO
import com.wkswind.server.api.protobuf.http.*
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.nio.charset.Charset

@Controller
@RequestMapping("/auth")
class AuthController {
	@PostMapping("phone", produces = [MEDIA_TYPE_PROTO], consumes = [MEDIA_TYPE_PROTO])
	@ResponseBody
	fun login(@RequestBody request: ClientRequest): ServerResponse {
		val json = JsonFormat.printer().print(request);
		println(json)
		val result = Result.newBuilder().setReturnCode(0).setMessage("success").build()
		val device = Device.newBuilder()
			.setBrand("brand").setChannel("channel").setModel("model").setOs("4.4")
			.setVersionCode(19).build()
		val header = Header.newBuilder().setAccount("account").setAppId("appId")
			.setDevice(device).setPlatform(Platform.ANDROID).setRefreshToken("refreshToken")
			.setToken("token").putExt("key", "value")
			.build()
		val body: ByteString = ByteString.copyFrom("Hello world", Charsets.UTF_8)
		val response = ServerResponse.newBuilder().setHeader(header).setResult(result).setBody(body).build()
		return response
	}
}