package com.pethat.backendk.model

import com.pethat.backendk.model.enums.Especialidade
import com.pethat.backendk.model.enums.Turno
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("veterinarios")
data class Veterinario(
    @Id
    val id: ObjectId = ObjectId(),
    val nome: String,
    val crmvce: String,
    val dataHabilitacao: LocalDateTime,
    var email: String,
    val numCelular: String,
    var senha: String,
    val especialidade: Especialidade,
    val turno: Turno,
    var consulta: MutableList<Consulta>
)