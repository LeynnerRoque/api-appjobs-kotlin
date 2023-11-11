package br.com.curso.api.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class Peoples (
        @Id
        @GeneratedValue( strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val name: String? = null,
        val gender: String? = null,
        val age: Int? = null,
        val regionName: String? = null,
        val email: String? = null,
        val phone: String? = null,
        @ManyToOne
        val job: Job,
        val location: Long? =null

)