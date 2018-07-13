package vn.com.datasection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.datasection.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email) throws RuntimeException;
}
