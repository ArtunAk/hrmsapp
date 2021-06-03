package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.VerifyCodeService;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/valid")
public class VerifyCodeController {
	
private VerifyCodeService verifyCodeService;
	
	@Autowired
	public VerifyCodeController(VerifyCodeService verifyCodeService) {
		super();
		this.verifyCodeService = verifyCodeService;
	}


	@PutMapping("/{verifyCode}")
	public Result update(@PathVariable("verifyCode") String verifyCode) {
		return verifyCodeService.verifyUser(verifyCode);
	}
	

}
