package com.example.onetomanyhibernate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


//https://www.baeldung.com/jpa-one-to-one
@SpringBootApplication
@Slf4j
public class OneToOneHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneToOneHibernateApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository repository) {
        return args -> {
            User user = new User();
            user.setName("tom");
            Address address = new Address();
            user.setAddress(address);
            address.setUser(user);
            address.setStreet("21st street");

            log.warn(user.toString());

            repository.save(user);

//            repository.delete(user);
        };
    }
}
