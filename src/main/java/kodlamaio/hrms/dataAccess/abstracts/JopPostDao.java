package kodlamaio.hrms.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobPost;

public interface JopPostDao extends JpaRepository<JobPost,Integer>{
	
	List<JobPost> findByIsActive(boolean status);
	List<JobPost> findByIsActiveOrderByClosedDate(boolean status);
	List<JobPost> findByIsActiveAndEmployer_CompanyName(boolean status, String companyName);
}
