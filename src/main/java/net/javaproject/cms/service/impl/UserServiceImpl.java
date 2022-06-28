package net.javaproject.cms.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import net.javaproject.cms.entity.Users;
import net.javaproject.cms.repository.UserRepository;
import net.javaproject.cms.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Users getUserById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public Users verifyLogin(String email, String password) {
		Users verifiedUser = userRepository.findByEmailAndPassword(email, password);
		return verifiedUser;
	}

}
