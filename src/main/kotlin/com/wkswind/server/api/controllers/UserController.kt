package com.wkswind.server.api.controllers

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class UserControllerU {
	@GetMapping("user/{id}")
	fun queryById(@PathVariable id: Int): String = "queryById: ${id} invokded"
	
	@PostMapping("user")
	fun addUser(): String = "addUser invoked"
	
	@PutMapping("user")
	fun updateUser(): String = "updateUser invoked"
	
	@DeleteMapping("user/{id}")
	fun deleteUser(@PathVariable id: Int): String = "deleteUser id: ${id} invoked"
}