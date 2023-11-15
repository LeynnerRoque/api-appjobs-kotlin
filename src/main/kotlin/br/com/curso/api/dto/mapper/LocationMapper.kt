package br.com.curso.api.dto.mapper

import br.com.curso.api.dto.LocationDTO
import br.com.curso.api.model.Location
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
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

    fun listDTO(list: List<Location>): List<LocationDTO>{
        return list.map { a -> toDTO(a) }.toList()
    }

    fun toPageDTO(listPage: Page<Location>): Page<LocationDTO>{
        val pageDTO = listPage.map { a->toDTO(a) }.toList()
        return PageImpl<LocationDTO>(pageDTO)
    }
}