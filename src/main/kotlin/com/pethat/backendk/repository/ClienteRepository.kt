package com.pethat.backendk.repository

import com.pethat.backendk.model.Cliente
import org.springframework.data.mongodb.repository.MongoRepository

interface ClienteRepository: MongoRepository<Cliente, String> {

    fun findByEmail(email: String): Cliente?

}