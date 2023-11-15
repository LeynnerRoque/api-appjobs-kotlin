package br.com.curso.api.dto.request

import br.com.curso.api.dto.LocationDTO
import br.com.curso.api.dto.mapper.IMapper
import br.com.curso.api.model.Location
import org.springframework.stereotype.Component

@Component
class LocationMapper: IMapper<LocationDTO, Location> {

    override fun mapTo(t: LocationDTO): Location {
        val entity = Location(
                t.id,
                t.streetAddress,
                t.postalCode,
                t.city,
                t.stateProvince,
        )
        return entity
    }

    fun toDTO(t: Location): LocationDTO{
        val dto = LocationDTO(
                t.id!!,
                t.streetAddress!!,
                t.postalCode!!,
                t.city!!,
                t.stateProvince!!
        )
        return dto
    }
}