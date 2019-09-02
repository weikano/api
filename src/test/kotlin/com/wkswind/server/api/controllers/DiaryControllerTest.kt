package com.wkswind.server.api.controllers

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

internal class DiaryControllerTest {
	
	@BeforeEach
	fun setUp() {
	}
	
	@Test
	fun addDiary() {
		val response = Client.api.addDiary("hello", "world").execute()
		println(response.body())
		Client.api.queryDiaryById(1).execute().also {
			println(it.body())
		}
	}
}