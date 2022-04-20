package com.ApiRestOdontologist.demo.Security;

import com.ApiRestOdontologist.demo.Entities.Auth.User;
import com.ApiRestOdontologist.demo.Entities.Auth.UserRoles;
import com.ApiRestOdontologist.demo.Repositories.Auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private final UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("examplePassword");
        String password2 = passwordEncoder.encode("examplePassword2");

        //userRepository.save(new User("tomas","tomasherrera12@gmail.com",password, UserRoles.ADMIN));
        //userRepository.save(new User("user","user@gmail.com",password2, UserRoles.USER));
        userRepository.delete(userRepository.getById(3));
        userRepository.delete(userRepository.getById(4));
        userRepository.delete(userRepository.getById(5));
        userRepository.delete(userRepository.getById(6));
    }
}
