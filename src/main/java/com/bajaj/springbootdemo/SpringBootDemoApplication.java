package com.bajaj.springbootdemo;

import com.bajaj.springbootdemo.entities.Address;
import com.bajaj.springbootdemo.entities.Customer;
import com.bajaj.springbootdemo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		insert();
//		read();
//		readById(1);
//		readByEmail("swapnil@gmail.com");
//		readByEmailAndMobileNumber("swapnil@gmail.com","9773953954");
//		readCustomers("Swapnil","Male");
//		updateCustomerName(1, "Swapnil Salvi");
	}


	private void insert() {
//		Customer customer = new Customer("Swapnil","26-10-1990","swapnil@gmail.com","1234","9773953954","Male");
//		Customer customer = new Customer("Amod","01-01-1987","amod@gmail.com","5678","9871524352","Male");s

//		Address address1 = new Address(1804, "Hill Spring", "Vijay Garden", "Thane", 400615);
//		address1.setCustomer(customer);
//
//		Address address2 = new Address(203, "Akshay Residency", "Wakad", "Pune", 411057);
//		address2.setCustomer(customer);

//		List<Address> addresses = new ArrayList<>();
//		addresses.add(address1);
//		addresses.add(address2);

//		customer.setAddresses(addresses);

//		customerRepository.save(customer);
	}

	private void read() {
		List<Customer> customerList = customerRepository.findAll();
		customerList.forEach(customer -> {
			System.out.println(customer);
		});
	}

	private void readById(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()){
			System.out.println(customer.get());
		}else{
			System.out.println("Customer not found");
		}
	}

	private void readByEmail(String email) {
		Optional<Customer> customerByEmail = customerRepository.findByEmailId(email);
		if (customerByEmail.isPresent()){
			System.out.println(customerByEmail.get());
		}else{
			System.out.println("Customer not found");
		}
	}

	private void readByEmailAndMobileNumber(String email, String mobileNumber) {
		Optional<Customer> customer = customerRepository.findByEmailIdAndMobileNumber(email,mobileNumber);
		if (customer.isPresent()){
			System.out.println(customer.get());
		}else{
			System.out.println("Customer not found");
		}
	}

	private void readCustomers(String name, String gender) {
		List<Customer> customers = customerRepository.findCustomers(name, gender);
		if (customers.stream().count() > 0) {
			customers.forEach(customer -> {
				System.out.println(customer);
			});
		}else{
			System.out.println("Customer not found");
		}
	}

	private void updateCustomerName(Long id, String updatedName) {
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			customer.get().setName(updatedName);
			customerRepository.save(customer.get());
		}else{
			System.out.println("Customer not found");
		}
	}
}