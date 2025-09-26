package com.khoavdse170395.accountservice.data;

import com.khoavdse170395.accountservice.model.Account;
import com.khoavdse170395.accountservice.model.Role;
import com.khoavdse170395.accountservice.repository.AccountRepository;
import com.khoavdse170395.accountservice.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GenerateData {

    @Bean
    CommandLineRunner seedInitialData(RoleRepository roleRepository, AccountRepository accountRepository) {
        return args -> {
            if (roleRepository.count() == 0) {
                Role admin = Role.builder().roleName("ADMIN").build();
                Role manager = Role.builder().roleName("MANAGER").build();
                Role user = Role.builder().roleName("USER").build();
                roleRepository.saveAll(List.of(admin, manager, user));
            }

            List<Role> roles = roleRepository.findAll();
            if (accountRepository.count() == 0 && !roles.isEmpty()) {
                Role adminRole = roles.stream().filter(r -> "ADMIN".equals(r.getRoleName())).findFirst().orElse(roles.get(0));
                Role managerRole = roles.stream().filter(r -> "MANAGER".equals(r.getRoleName())).findFirst().orElse(roles.get(0));
                Role userRole = roles.stream().filter(r -> "USER".equals(r.getRoleName())).findFirst().orElse(roles.get(0));

                Account a1 = Account.builder().username("admin").password("admin123").email("admin@example.com").role(adminRole).active(true).build();
                Account a2 = Account.builder().username("manager").password("manager123").email("manager@example.com").role(managerRole).active(true).build();
                Account a3 = Account.builder().username("user1").password("password1").email("user1@example.com").role(userRole).active(true).build();
                Account a4 = Account.builder().username("user2").password("password2").email("user2@example.com").role(userRole).active(true).build();
                Account a5 = Account.builder().username("user3").password("password3").email("user3@example.com").role(userRole).active(true).build();
                Account a6 = Account.builder().username("user4").password("password4").email("user4@example.com").role(userRole).active(true).build();
                Account a7 = Account.builder().username("user5").password("password5").email("user5@example.com").role(userRole).active(true).build();
                Account a8 = Account.builder().username("user6").password("password6").email("user6@example.com").role(userRole).active(true).build();
                Account a9 = Account.builder().username("user7").password("password7").email("user7@example.com").role(userRole).active(true).build();
                Account a10 = Account.builder().username("user8").password("password8").email("user8@example.com").role(userRole).active(true).build();

                accountRepository.saveAll(List.of(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10));
            }
        };
    }
}
