package vn.com.datasection.servicer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.datasection.model.User;
import vn.com.datasection.repository.UserRepository;
import vn.com.datasection.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void save(User user) throws RuntimeException {
		this.userRepository.save(user);
	}

	@Override
	public User findUserByEmail(String email) {
		try {
			return userRepository.findByEmail(email);
		} catch (Exception e) {
			return new User();
		}
	}

	@Override
	public User findUserById(int id) {
		return userRepository.findUserById(id);
	}
	
}
