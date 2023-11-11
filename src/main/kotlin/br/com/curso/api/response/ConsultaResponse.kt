package br.com.curso.api.response

data class ConsultaResponse(
        val medicoNome: String? = null,
        val crm: String? = null,
        val pacienteNome: String? = null,
        val cpf: String? = null
)