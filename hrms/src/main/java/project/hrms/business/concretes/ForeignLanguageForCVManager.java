package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.hrms.business.abstracts.ForeignLanguageForCVService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.ForeignLanguageForCVDao;
import project.hrms.entities.concretes.ForeignLanguageForCV;

@Service
public class ForeignLanguageForCVManager implements ForeignLanguageForCVService{

	private ForeignLanguageForCVDao foreignLanguageForCVDao;
	
	@Autowired
	public ForeignLanguageForCVManager(ForeignLanguageForCVDao foreignLanguageForCVDao) {
		super();
		this.foreignLanguageForCVDao = foreignLanguageForCVDao;
	}

	@Override
	public Result add(ForeignLanguageForCV foreignLanguageForCV) {
		this.foreignLanguageForCVDao.save(foreignLanguageForCV);
		return new SuccessResult("Foreign language has been added.");
	}

	@Override
	public Result update(ForeignLanguageForCV foreignLanguageForCV) {
		this.foreignLanguageForCVDao.save(foreignLanguageForCV);
		return new SuccessResult("Foreign language has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.foreignLanguageForCVDao.deleteById(id);;
		return new SuccessResult("Foreign language has been deleted.");
	}

	@Override
	public DataResult<ForeignLanguageForCV> getById(int id) {
		return new SuccessDataResult<ForeignLanguageForCV>(this.foreignLanguageForCVDao.getById(id));
	}

	@Override
	public DataResult<List<ForeignLanguageForCV>> getAll() {
		return new SuccessDataResult<List<ForeignLanguageForCV>>(this.foreignLanguageForCVDao.findAll());
	}

	@Override
	public DataResult<List<ForeignLanguageForCV>> getAllByJobSeekerId(int id) {
		return new SuccessDataResult<List<ForeignLanguageForCV>>(this.foreignLanguageForCVDao.getAllByJobSeeker_id(id));
	}

}
