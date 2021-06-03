package kodlamaio.hrms.core.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.abstracts.MernisCheckService;
import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Component
public class MernisCheckAdapter implements MernisCheckService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		KPSPublicSoapProxy kpsPublic;
		try {
			kpsPublic = new KPSPublicSoapProxy();
			boolean durum = kpsPublic.TCKimlikNoDogrula(
					Long.parseLong(candidate.getNationalIdentity()), 
							candidate.getName().toUpperCase(), 
							candidate.getSurname().toUpperCase(), 
							Integer.parseInt(candidate.getBirth_year()));
			return durum;
		} catch (RemoteException | NumberFormatException e1) {
			e1.printStackTrace();
		}
			return false;
	}
	

	
	

}
