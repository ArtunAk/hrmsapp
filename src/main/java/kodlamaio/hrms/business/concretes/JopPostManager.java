package kodlamaio.hrms.business.concretes;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostDao;
import kodlamaio.hrms.entities.concretes.JobPost;
import kodlamaio.hrms.entities.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.dtos.JobPostingDto;

@Service
public class JopPostManager implements JobPostService {
	
	private JobPostDao jobPostingDao;
	private DtoConverterService dtoConverterService;
		
	
	@Autowired
	public JopPostManager(JobPostDao jobPostingDao, DtoConverterService dtoConverterService) {
		super();
		this.jobPostingDao = jobPostingDao;
		this.dtoConverterService = dtoConverterService;
	}
	
	@Override
	public Result add(JobPostingAddDto jobPostingAddDto) {
		this.jobPostingDao.save((JobPost) dtoConverterService.dtoClassConverter(jobPostingAddDto, JobPost.class));
		return new SuccessResult("İş İlanı Eklendi");
	}
	@Override
	public Result delete(JobPost jobPosting) {
		this.jobPostingDao.delete(jobPosting);
		return new SuccessResult("Silme işlemi Tamamlandı");
	}
	@Override
	public DataResult<List<JobPostingDto>> findByIsActive() {
		return new SuccessDataResult<List<JobPostingDto>>(dtoConverterService.dtoConverter
				(jobPostingDao.findByIsActive(true), JobPostingDto.class),"Aktif İş İlanları Listelendi");
		
	}
	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate() {
		return new SuccessDataResult<List<JobPostingDto>>
		(this.dtoConverterService.dtoConverter(this.jobPostingDao.findByIsActiveOrderByClosedDate(true), JobPostingDto.class),"Data Listelendi");
	}
	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobPostingDto>>
		(this.dtoConverterService.dtoConverter(this.jobPostingDao.findByIsActiveAndEmployer_CompanyName(true, companyName), JobPostingDto.class),"Data Listelendi");
	}
	
	

}
