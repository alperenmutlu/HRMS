package project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import project.hrms.business.abstracts.UserService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.UserDao;
import project.hrms.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("User has been added.");
	}

	

	//@Override
	//public Result update(User user) {
	//	this.userDao.save(user);
	//	return new SuccessResult("User has been updated");
	//}

	//@Override
	//public Result delete(int id) {
	//	this.userDao.deleteById(id);
	//	return new SuccessResult("User has been deleted");
	//}

	//@Override
	//public DataResult<User> getById(int id) {
	//	return new SuccessDataResult<User>(this.userDao.getOne(id));
	//}
	
	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Users Listed");
	}

	
	@Override
	public DataResult<User> getUserByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findUserByEmail(email));
	}
}
