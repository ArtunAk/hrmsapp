package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import kodlamaio.hrms.business.abstracts.JobPostService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JopPostDao;
import kodlamaio.hrms.entities.concretes.JobPost;
import kodlamaio.hrms.entities.dtos.JobPostingDto;

public class JopPostManager implements JobPostService {
	
	private JopPostDao jobPostingDao;
	private ModelMapper modelMapper;
	
	
	public JopPostManager(JopPostDao jobPostingDao, ModelMapper modelMapper) {
		super();
		this.jobPostingDao = jobPostingDao;
		this.modelMapper = modelMapper;
	}

	private List<JobPostingDto> dtoConverter(List<JobPost> jobPosting){
		List<JobPostingDto> jPDto = new ArrayList<JobPostingDto>();
		jobPosting.forEach(x -> {
			JobPostingDto dto = this.modelMapper.map(x, JobPostingDto.class);
			dto.setEmployerCompanyName(x.getEmployer().getCompanyName());
			jPDto.add(dto);
		});
		
		return jPDto;
		
		
	}
	
	@Override
	public Result add(JobPost jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("İş İlanı Eklendi");
	}
	@Override
	public Result delete(JobPost jobPosting) {
		this.jobPostingDao.delete(jobPosting);
		return new SuccessResult("Silme işlemi Tamamlandı");
	}
	@Override
	public DataResult<List<JobPostingDto>> findByIsActive() {
		return new SuccessDataResult<List<JobPostingDto>>
		(this.dtoConverter(this.jobPostingDao.findByIsActive(true)),"Data Listelendi");
	}
	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate() {
		return new SuccessDataResult<List<JobPostingDto>>
		(this.dtoConverter(this.jobPostingDao.findByIsActiveOrderByClosedDate(true)),"Data Listelendi");
	}
	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobPostingDto>>
		(this.dtoConverter(this.jobPostingDao.findByIsActiveAndEmployer_CompanyName(true, companyName)),"Data Listelendi");
	}

}
