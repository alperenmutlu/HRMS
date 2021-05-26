package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	Result add(VerificationCode code);
	
	//Result delete(VerificationCode code);
	//Result update(VerificationCode code);
	
	//DataResult<VerificationCode> getById(int id);
	//DataResult<List<VerificationCode> >getAll();
	
}
