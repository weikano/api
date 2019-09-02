package com.wkswind.server.api.controllers

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class DiaryController {
	@GetMapping("diary/{id}")
	fun queryById(@PathVariable id: Int): String = "queryById: ${id} invokded"
	
	@PostMapping("diary")
	fun addDiary(@RequestParam("name") name: String, @RequestParam("content") content: String): String = "addDiary invoked with $name and $content"
	
	@PutMapping("diary")
	fun updateDiary(): String = "updateDiary invoked"
	
	@DeleteMapping("diary/{id}")
	fun deleteDiary(@PathVariable id: Int): String = "deleteDiary id: ${id} invoked"
}