package com.pethat.backendk.controller

import com.pethat.backendk.model.Veterinario
import com.pethat.backendk.service.VeterinarioService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/veterinario")
class ControllerVeterinario(val service: VeterinarioService) {

    @GetMapping("/{email}")
    fun findByEmail(@PathVariable email:String): ResponseEntity<Veterinario> {
        val veterinario = service.findByEmail(email)
        return ResponseEntity(veterinario, HttpStatus.OK)
    }

    @PostMapping("/")
    fun insertVeterinario(@RequestBody veterinario: Veterinario): ResponseEntity<Veterinario>{
        val veterinario = service.insertVeterinario(veterinario)
        return ResponseEntity(veterinario, HttpStatus.CREATED)
    }
}