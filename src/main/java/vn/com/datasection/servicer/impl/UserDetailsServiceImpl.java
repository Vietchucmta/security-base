package vn.com.datasection.servicer.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.datasection.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = new User();
		user.setEmail("Vietchucmta11@gmail.com");
		user.setPassword("$2a$10$9To4mCvFj.QHKi.vPtQtP.5xkA9UhnQ4pWzZvKykUBNah8FTsNaoe");
		user.setEnable(true);
		UserBuilder builder = null;
		if (user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(email);
			builder.disabled(!user.getEnable());
			builder.password(user.getPassword());
			String authority = "ROLE_USER";
			builder.authorities(authority);
		}
		return builder.build();
	}

}
