package br.com.curso.api.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Location (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val streetAddress: String? = null,
        val postlCode: String? = null,
        val city: String? = null,
        val stateProvince: String? = null

)