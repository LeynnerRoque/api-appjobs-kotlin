package br.com.curso.api.service

import br.com.curso.api.dto.EnterpriseDTO
import br.com.curso.api.dto.request.EnterpriseMapper
import br.com.curso.api.model.Enterprise
import br.com.curso.api.repository.EnterpriseRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EnterpriseService (private val repository: EnterpriseRepository,
                         private val mapper: EnterpriseMapper
){

    @Transactional
    fun create(request: EnterpriseDTO): Enterprise{
        val enterprise = mapper.mapTo(request)
        return repository.save(enterprise)
    }
}