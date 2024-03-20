package com.pethat.backendk.model

import com.pethat.backendk.model.enums.StatusConsulta
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
@Document("consulta")
data class Consulta(
    val data: LocalDateTime,
    val hora: LocalDateTime,
    val status: StatusConsulta,
    val veterinario: Veterinario
)