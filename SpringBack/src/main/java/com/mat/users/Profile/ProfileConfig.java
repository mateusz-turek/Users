package com.mat.users.Profile;

import com.mat.users.Model.User;
import com.mat.users.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("profile")
@Configuration
public class ProfileConfig {

    @Bean
    public CommandLineRunner helloProfile(UserRepository userRepository){
        return args -> {
            System.out.println("hello profile");

            if( userRepository.count() == 0){
                User user1 = new User();
                user1.setName("User1");
                user1.setSurname("Surname1");
                user1.setAge(18);
                User user2 = new User();
                user2.setName("User2");
                user2.setSurname("Surname2");
                user2.setAge(20);
                User user3 = new User();
                user3.setAge(22);
                user3.setName("User3");
                user3.setSurname("Surname3");
                System.out.println("insert into db examples");
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
        }};
    }
}
