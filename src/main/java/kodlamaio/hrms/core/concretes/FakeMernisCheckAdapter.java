package kodlamaio.hrms.core.concretes;

import kodlamaio.hrms.core.abstracts.MernisCheckService;
import kodlamaio.hrms.entities.concretes.Candidate;

public class FakeMernisCheckAdapter implements MernisCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		
		return true;
	}

}
