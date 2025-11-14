package com.nfsystems.rhsync_api;

import com.nfsystems.rhsync_api.role.models.Role;
import com.nfsystems.rhsync_api.role.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EnableJpaAuditing
@SpringBootApplication
public class RhsyncApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhsyncApiApplication.class, args);
	}

    @Bean
    public CommandLineRunner runner(RoleRepository roleRepository) {
        Set<Role> roles = new HashSet<>();
        return args -> {
            if(roleRepository.findByName("EMPLOYEE").isEmpty()) {
                roles.add(Role.builder().name("EMPLOYEE").build());
            }
            if(roleRepository.findByName("MANAGER").isEmpty()) {
                roles.add(Role.builder().name("MANAGER").build());
            }
            if(roleRepository.findByName("MANAGER_SECTOR").isEmpty()) {
                roles.add(Role.builder().name("MANAGER_SECTOR").build());
            }
            if(roleRepository.findByName("DIRECTOR").isEmpty()) {
                roles.add(Role.builder().name("DIRECTOR").build());
            }
            if(roleRepository.findByName("ADMIN").isEmpty()) {
                roles.add(Role.builder().name("ADMIN").build());
            }
            if(roleRepository.findByName("TI").isEmpty()) {
                roles.add(Role.builder().name("TI").build());
            }
            if(roleRepository.findByName("SECRETARY").isEmpty()) {
                roles.add(Role.builder().name("SECRETARY").build());
            }

            roleRepository.saveAll(roles);
        };
    }
}
