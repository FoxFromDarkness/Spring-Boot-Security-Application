package pl.minda.javaspringbooth2databasespringsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class InitClass {

    private UserRepo userRepo;
    private UserRoleRepo userRoleRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public InitClass(UserRepo userRepo, UserRoleRepo userRoleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.userRoleRepo = userRoleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {

        UserRole role_ADMIN = new UserRole("ROLE_ADMIN");
        UserRole role_USER = new UserRole("ROLE_USER");

        User admin = new User("admin", passwordEncoder.encode("admin"));
        User user = new User("user", passwordEncoder.encode("user"));

        role_ADMIN.setUsers(Collections.singletonList(admin));
        role_USER.setUsers(Collections.singletonList(user));

        admin.setRoles(Collections.singletonList(role_ADMIN));
        user.setRoles(Collections.singletonList(role_USER));

        userRepo.save(admin);
        userRepo.save(user);

        userRoleRepo.save(role_ADMIN);
        userRoleRepo.save(role_USER);
    }
}
