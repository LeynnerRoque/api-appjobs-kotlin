package br.com.curso.api.repository

import br.com.curso.api.model.Enterprise
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface EnterpriseRepository : JpaRepository<Enterprise, Long>{
}