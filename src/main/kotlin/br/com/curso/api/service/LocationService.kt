package br.com.curso.api.service

import br.com.curso.api.dto.LocationDTO
import br.com.curso.api.dto.request.LocationMapper
import br.com.curso.api.repository.LocationRepository
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
}