package org.springframework.projectname;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;

@SpringBootApplication
public class ProjectNameApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectNameApplication.class, args);
	}

    @Bean
    ApplicationRunner init(AddressRepository repository) {
        System.out.println("hello2");

        return args -> {
            Stream.of("Peter", "Schaber", "Ben", "DeVries", "Michael", "Carll")
                    .forEach(name -> {
                        Address addr = new Address();
                        addr.setName(name);
                        repository.save(addr);
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}
