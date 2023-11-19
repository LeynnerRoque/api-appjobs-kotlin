package br.com.curso.api.service

import br.com.curso.api.dto.PeoplesDTO
import br.com.curso.api.dto.mapper.PeoplesMapper
import br.com.curso.api.dto.response.PeoplesResponseDTO
import br.com.curso.api.model.Peoples
import br.com.curso.api.repository.PeoplesRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PeoplesService (private val repository: PeoplesRepository,
        private val mapper: PeoplesMapper){

    @Transactional
    fun create(request: PeoplesDTO): PeoplesResponseDTO{
        val entity: Peoples = repository.save(mapper.mapTo(request))
        return mapper.toDTO(entity)
    }

    @Transactional
    fun update(request: PeoplesDTO): PeoplesResponseDTO{
        if(request.id == null){
            return throw Exception()
        }
        val requestUpdate = repository.save(mapper.mapTo(request))
        return mapper.toDTO(requestUpdate)
    }

    @Transactional
    fun delete(id: Long){
        if(repository.existsById(id)){
            repository.deleteById(id)
        }
    }

    fun listAll(): List<PeoplesResponseDTO>{
        return mapper.listDTO(repository.findAll())
    }

    fun pagination(pageable: Pageable): Page<PeoplesResponseDTO>{
        return mapper.pageTo(repository.findAll(pageable))
    }

    fun listByJobTitle(title: String): List<PeoplesResponseDTO>{
        return mapper.listDTO(repository.findPeoplesByJob_Title(title))
    }
}