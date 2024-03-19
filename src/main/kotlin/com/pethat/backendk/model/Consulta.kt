package com.pethat.backendk.model

import com.pethat.backendk.model.enums.StatusConsulta
import java.time.LocalDateTime

data class Consulta(val data: LocalDateTime, val hora: LocalDateTime, val status: StatusConsulta)