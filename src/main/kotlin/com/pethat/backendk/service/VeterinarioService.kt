package com.pethat.backendk.service

import com.pethat.backendk.model.Veterinario
import com.pethat.backendk.repository.VeterinarioRepository
import org.springframework.stereotype.Service

@Service
class VeterinarioService(val repository: VeterinarioRepository) {
    fun findByEmail(email: String): Veterinario? = repository.findByEmail(email)
    fun insertVeterinario(veterinario: Veterinario): Veterinario = repository.insert(veterinario)

}
