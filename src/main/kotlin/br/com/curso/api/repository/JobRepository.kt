package br.com.curso.api.repository

import br.com.curso.api.model.Job
import org.springframework.data.jpa.repository.JpaRepository

interface JobRepository: JpaRepository<Job, Long> {

    fun findJobByTitle(title: String): Job
}