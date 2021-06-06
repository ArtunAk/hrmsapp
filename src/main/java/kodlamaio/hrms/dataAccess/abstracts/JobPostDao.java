package kodlamaio.hrms.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobPost;

@Repository
public interface JobPostDao extends JpaRepository<JobPost,Integer>{
	
	List<JobPost> findByIsActive(boolean status);
	List<JobPost> findByIsActiveOrderByClosedDate(boolean status);
	List<JobPost> findByIsActiveAndEmployer_CompanyName(boolean status, String companyName);
}
