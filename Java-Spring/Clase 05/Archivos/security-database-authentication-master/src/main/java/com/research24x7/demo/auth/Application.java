
package com.research24x7.demo.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.research24x7.demo.auth.model.User;
import com.research24x7.demo.auth.repository.UserRepository;


@SpringBootApplication
public class Application implements CommandLineRunner {


	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;


	@Override
	public void run (String... args) throws Exception {

		this.userRepository.save ( new User("hsimpson", bCryptPasswordEncoder.encode("qwerty"), "Homer", "Simpson"));
	}


	public static void main (String[] args) {

		SpringApplication.run (Application.class, args);
	}
}
