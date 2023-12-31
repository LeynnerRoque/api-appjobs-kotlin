package br.com.curso.api.service

import br.com.curso.api.dto.EnterpriseDTO
import br.com.curso.api.dto.mapper.EnterpriseMapper
import br.com.curso.api.repository.EnterpriseRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EnterpriseService (private val repository: EnterpriseRepository,
                         private val mapper: EnterpriseMapper
){

    @Transactional
    fun create(request: EnterpriseDTO): EnterpriseDTO{
        val enterprise = mapper.mapTo(request)
        val response = repository.save(enterprise)
        return mapper.toDTO(response)
    }

    fun listAll(): List<EnterpriseDTO>{
        return mapper.toList(repository.findAll())
    }

    @Transactional
    fun update(request: EnterpriseDTO): EnterpriseDTO{
        if(repository.findById(request.id) == null){
            return throw Exception()
        }
        val enterprise = mapper.mapTo(request)
        val updateResponse = repository.save(enterprise)
        return mapper.toDTO(updateResponse)
    }

    @Transactional
    fun delete(id: Long){
        repository.deleteById(id)
    }

    fun pagination(page: Pageable): Page<EnterpriseDTO>{
        return mapper.toPage(repository.findAll(page))
    }

    fun filterByName(name: String): EnterpriseDTO{
        return mapper.toDTO(repository.findEnterpriseByFoundationName(name))
    }
}