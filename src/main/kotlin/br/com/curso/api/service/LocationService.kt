package br.com.curso.api.service

import br.com.curso.api.dto.LocationDTO
import br.com.curso.api.dto.mapper.LocationMapper
import br.com.curso.api.repository.LocationRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LocationService(
        private val repository: LocationRepository,
        private val mapper: LocationMapper) {

    @Transactional
    fun create(request: LocationDTO): LocationDTO{
        val entity = repository.save(mapper.mapTo(request))
        return mapper.toDTO(entity)
    }

    fun listALL(): List<LocationDTO>{
        return mapper.listDTO(repository.findAll())
    }

    fun pagination(pageable: Pageable): Page<LocationDTO>{
        return mapper.toPageDTO(repository.findAll(pageable))
    }

   @Transactional
    fun update(request: LocationDTO): LocationDTO{
        if(request.id == null){
            return throw Exception()
        }
        val update = mapper.mapTo(request)
        return mapper.toDTO(repository.save(update))
    }

    @Transactional
    fun delete(id: Long){
        repository.deleteById(id)
    }
}