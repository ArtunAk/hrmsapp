package kodlamaio.hrms.core.utilities.email;

public class EmailSender implements EmailSenderService {

	@Override
	public void send(String mail) {
		System.out.println("Mail gonderildi" + mail);
	}
	

}
