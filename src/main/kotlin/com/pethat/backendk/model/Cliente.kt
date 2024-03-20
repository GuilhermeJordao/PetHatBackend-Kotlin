package com.pethat.backendk.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "cliente")
data class Cliente (
        @Id
        val id: ObjectId = ObjectId(),
        var nome: String = "",
        var cpf: String = "",
        var email: String = "",
        var senha: String  = "",
)
