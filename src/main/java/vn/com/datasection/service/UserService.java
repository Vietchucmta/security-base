package vn.com.datasection.service;

import vn.com.datasection.model.User;

public interface UserService {
	public void save(User user);

	public User findUserByEmail(String email);
}
