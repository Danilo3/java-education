package com.koryakin.mongodemo;

import com.koryakin.mongodemo.domain.Customer;
import com.koryakin.mongodemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodemoApplication implements CommandLineRunner{


	@Autowired
	CustomerRepository customerRepository;


	public static void main(String[] args) {
		SpringApplication.run(MongodemoApplication.class, args);


	}

	@Override
	public void run(String... strings) throws Exception {

		customerRepository.deleteAll();
		// save a couple of customers
		customerRepository.save(new Customer("Alice", "Smith"));
		customerRepository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(customerRepository.findCustomerByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : customerRepository.findCustomersByLastName("Smith")) {
			System.out.println(customer);

		}
	}
}