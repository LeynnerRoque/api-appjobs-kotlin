package br.com.curso.api.service

import br.com.curso.api.dto.JobDTO
import br.com.curso.api.dto.mapper.JobMapper
import br.com.curso.api.dto.response.JobResponseDTO
import br.com.curso.api.repository.JobRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class JobService (
        private val mapper: JobMapper,
        private val repository: JobRepository){

    @Transactional
    fun create(request: JobDTO): JobResponseDTO{
        val response = repository.save(mapper.mapTo(request))
        return mapper.toDTO(response)
    }

    @Transactional
    fun update(request: JobDTO): JobResponseDTO{
        if(request.id == null){
            return throw Exception()
        }
        val response = repository.save(mapper.mapTo(request))
        return mapper.toDTO(response)
    }

    @Transactional
    fun delete(id: Long){
        repository.deleteById(id)
    }

    fun listAll(): List<JobResponseDTO>{
        return mapper.listDTO(repository.findAll())
    }

    fun pageAll(pageable: Pageable): Page<JobResponseDTO>{
        return mapper.toPageDTO(repository.findAll(pageable))
    }

    fun filterByTitle(title: String): JobResponseDTO{
        return mapper.toDTO(repository.findJobByTitle(title))
    }
}