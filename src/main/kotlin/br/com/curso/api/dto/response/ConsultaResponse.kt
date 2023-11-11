package br.com.curso.api.dto.response

data class ConsultaResponse(
        val medicoNome: String? = null,
        val crm: String? = null,
        val pacienteNome: String? = null,
        val cpf: String? = null
)