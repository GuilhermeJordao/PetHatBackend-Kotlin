package com.pethat.backendk.repository

import com.pethat.backendk.model.Veterinario
import org.springframework.data.mongodb.repository.MongoRepository

interface VeterinarioRepository: MongoRepository<Veterinario, String> {
    fun findByEmail(email: String): Veterinario?
}
