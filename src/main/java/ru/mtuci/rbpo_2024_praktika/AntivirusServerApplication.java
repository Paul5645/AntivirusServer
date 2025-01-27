package ru.mtuci.rbpo_2024_praktika;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.mtuci.rbpo_2024_praktika.model.ApplicationRole;
import ru.mtuci.rbpo_2024_praktika.model.ApplicationUser;
import ru.mtuci.rbpo_2024_praktika.repository.RoleRepository;
import ru.mtuci.rbpo_2024_praktika.repository.UserRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class AntivirusServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AntivirusServerApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(UserRepository userRepo, RoleRepository roleRepo, PasswordEncoder passwordEncoder){
		return args -> {
			ApplicationRole adminRole = new ApplicationRole();
			adminRole.setName("ROLE_ADMIN");
			ApplicationRole userRole = new ApplicationRole();
			userRole.setName("ROLE_USER");
			roleRepo.save(adminRole);
			roleRepo.save(userRole);
			ApplicationUser admin = new ApplicationUser();
			admin.setUsername("admin");
			admin.setPassword(passwordEncoder.encode("123456"));
			admin.setEmail("admin@gmail.com");
			admin.setRoles(Arrays.asList(adminRole));
			ApplicationUser user1 = new ApplicationUser();
			user1.setUsername("user1");
			user1.setPassword(passwordEncoder.encode("1234"));
			user1.setEmail("user1@gmail.com");
			user1.setRoles(Arrays.asList(userRole));
			userRepo.save(user1);
			userRepo.save(admin);
		};
	}

}
