package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.CoverLetterForCV;

public interface CoverLetterForCVService {

	Result add(CoverLetterForCV coverLetterForCV);
	Result update(CoverLetterForCV coverLetterForCV);
	Result delete(int id);
	DataResult<CoverLetterForCV> getById(int id);	
	DataResult<List<CoverLetterForCV>> getAll();
}