package com.san4n.ptpshopping;

import com.san4n.ptpshopping.entity.core.Role;
import com.san4n.ptpshopping.entity.core.User;
import com.san4n.ptpshopping.entity.core.UserRole;
import com.san4n.ptpshopping.repository.RoleRepository;
import com.san4n.ptpshopping.repository.UserRepository;
import com.san4n.ptpshopping.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PtpShoppingApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	public static void main(String[] args) {
		SpringApplication.run(PtpShoppingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role role = roleRepository.save(
				Role.builder()
						.name("ADMIN")
						.description("ADMIN")
						.status(Role.STATUS_ACTIVE)
						.build()
		);

		User user = userRepository.save(
				User.builder()
						.name("ADMIN")
						.email("admin@admin.san")
						.password(passwordEncoder.encode("admin"))
						.userName("admin")
						.status(User.STATUS_ACTIVE)
						.build()
		);

		UserRole userRole = userRoleRepository.save(
				UserRole.builder()
				.role(role)
				.user(user)
				.status(UserRole.STATUS_ACTIVE)
				.build()
		);

	}
}
