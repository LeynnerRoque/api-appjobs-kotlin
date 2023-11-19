package br.com.curso.api.dto.mapper

import br.com.curso.api.dto.PeoplesDTO
import br.com.curso.api.dto.response.PeoplesResponseDTO
import br.com.curso.api.model.Job
import br.com.curso.api.model.Location
import br.com.curso.api.model.Peoples
import br.com.curso.api.repository.JobRepository
import br.com.curso.api.repository.LocationRepository
import org.springframework.beans.BeanUtils
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.stereotype.Component

@Component
class PeoplesMapper(private val jobRepository: JobRepository,
                    private val locationRepository: LocationRepository) :
IMapper<PeoplesDTO, Peoples>{

    override fun mapTo(t: PeoplesDTO): Peoples {
        val job: Job = jobRepository.findById(t.jobId!!).get()
        val location: Location = locationRepository.findById(t.locationId!!).get()
        val peoples = Peoples(t.id!!, t.name,
                t.gender,t.age,
                t.regionName,t.email,t.phone,
                job,location)
        return peoples
    }

    fun toDTO(t: Peoples): PeoplesResponseDTO{
        val dto = PeoplesResponseDTO(
                t.id,t.name,t.gender,
                t.age,t.regionName,
                t.email,t.phone,
                t.job.title,t.location.city
        )
        return dto
    }

    fun listDTO(list: List<Peoples>) : List<PeoplesResponseDTO>{
        return list.map { a -> toDTO(a)}
    }

    fun pageTo(page: Page<Peoples>): Page<PeoplesResponseDTO>{
        val pageDTO = page.map { a -> toDTO(a)}.toList()
        return PageImpl<PeoplesResponseDTO>(pageDTO)
    }


}