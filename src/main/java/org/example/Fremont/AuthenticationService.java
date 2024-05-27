//package org.example.Fremont;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthenticationService {
//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//	public boolean authenticate(String username, String password) {
//		User user = userRepository.findByUsername(username);
//		if (user != null && bCryptPasswordEncoder.matches(password, user.getPassword())) {
//			return true;
//		}
//		return false;
//	}
//}
package org.example.Fremont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public boolean authenticate(String username, String password) {
		User user = userRepository.findByUsername(username);
		if (user != null ) { //&& passwordEncoder.matches(password, user.getPassword())
			return true;
		}
		return false;
	}
}

