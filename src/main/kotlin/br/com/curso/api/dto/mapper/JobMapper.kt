package br.com.curso.api.dto.mapper

import br.com.curso.api.dto.JobDTO
import br.com.curso.api.model.Enterprise
import br.com.curso.api.model.Job
import br.com.curso.api.repository.EnterpriseRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.stereotype.Component

@Component
class JobMapper (private val enterpriseRepository: EnterpriseRepository): IMapper<JobDTO, Job>{

    override fun mapTo(t: JobDTO): Job {
        val entity = Job(
                t.id,
                t.title,
                t.description,
                t.salary,
                getEnterpriseById(t.enterpriseId!!)
        )
        return entity
    }

   fun getEnterpriseById(id: Long): Enterprise{
       return enterpriseRepository.findById(id).get()
   }

    fun toDTO(t: Job): JobDTO{
        val dto : JobDTO = JobDTO(
                t.id,
                t.title,
                t.description,
                t.salary,
                t.enterprise.id
        )
        return dto
    }

    fun listDTO(list: List<Job>): List<JobDTO>{
        return list.map { a -> toDTO(a) }
    }

    fun toPageDTO(page: Page<Job>): Page<JobDTO>{
        val pagDto = page.map { a -> toDTO(a) }.toList()
        return PageImpl<JobDTO>(pagDto)
    }
}