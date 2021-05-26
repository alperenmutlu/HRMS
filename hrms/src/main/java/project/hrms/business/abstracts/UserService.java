package project.hrms.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.User;

@Service
public interface UserService {
	Result add(User user);
	
	//Result update(User user);
	//Result delete(int id);
	//DataResult<User> getById(int id);
	
	DataResult<List<User>> getAll();
	DataResult<User> getUserByEmail(String email);
}
