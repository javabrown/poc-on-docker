package com.javabrown;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.javabrown.config.ServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
 
	
    @Autowired
    private ServerProperties serverProperties;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(serverProperties);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }


	@Bean
	public CommandLineRunner demo1(UserRepository userRepository) {
		return (args) -> {
				
			User user = new User();
			user.setUsername("rkhan");
			user.setPassword("password");
			user.setUsername("rkhan1");
			user.setPassword("password1");
			userRepository.save(user);
			
			List<User> allUser = userRepository.findAll();
			for(User u : allUser){
				System.out.printf("DB ==> %s | \n", u.getUsername());
			}
		};
	}
	
	/*@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Customer("Raja", "Khan"));
			repository.save(new Customer("Zidan", "Khan"));
			repository.save(new Customer("RajaA", "Khan"));

			// fetch all customers
			System.out.println("Customers found with findAll():");
			System.out.println("-------------------------------");
			for (Customer customer : repository.findAll()) {
				System.out.println(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findOne(1L);
			System.out.println("Customer found with findOne(1L):");
			System.out.println("--------------------------------");
			System.out.println(customer.toString());
			System.out.println("");

			// fetch customers by last name
			System.out.println("Customer found with findByLastName('Bauer'):");
			System.out.println("--------------------------------------------");
			for (Customer bauer : repository.findByLastName("Bauer")) {
				System.out.println(bauer.toString());
			}
			log.info("");
		};
	}*/
}