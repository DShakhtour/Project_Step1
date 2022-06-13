package com.duaa.project.Customer;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
public class CustomerController {
	private CustomerRepository repository ;

	private  CustomerModelAssembler assembler;
	
	@Autowired
	CustomerController(CustomerRepository repository, CustomerModelAssembler assembler) {

		this.repository = repository;
		this.assembler = assembler;
	}
	@GetMapping("/customers")
	public
	CollectionModel<EntityModel<Customer>> all() {

		List<EntityModel<Customer>> customers = repository.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());

		return CollectionModel.of(customers, linkTo(methodOn(CustomerController.class).all()).withSelfRel());
	}
	
	@PostMapping("/customers")
	Customer newCustomer(@RequestBody Customer newCustomer) {
		return repository.save(newCustomer);
	}
	
	@GetMapping("/customers/{id}")
	public EntityModel<Customer> one(@PathVariable int id) {

		Customer customers = repository.findById(id) //
				.orElseThrow(() -> new CustomerNotFoundException(id));

		return assembler.toModel(customers);
		}

	@PutMapping("/customers/{id}")
	Customer replacecustomer(@RequestBody Customer customer, @PathVariable int id) {

		return repository.findById(id).map(customers -> {
			customer.setCustomerNumber(customer.getCustomerNumber());
			customer.setPhone(customer.getPhone());
			customer.setAddressLine1(customer.getAddressLine1());
			customer.setAddressLine2(customer.getAddressLine2());
			customer.setCountry(customer.getCountry());
			customer.setCity(customer.getCity());
			customer.setContactFirstName(customer.getContactFirstName());
			customer.setContactLastName(customer.getContactLastName());
			customer.setCreditLimit(customer.getCreditLimit());
			customer.setCustomerName(customer.getCustomerName());
			
			
			customer.setPostalCode(customer.getPostalCode());
			return repository.save(customer);
		}).orElseGet(() -> {
			customer.setCustomerNumber((long) id);
			return repository.save(customer);
		});
	}

	@DeleteMapping("/customers/{id}")
	void deletePatient(@PathVariable int id) {
		repository.deleteById(id);
	}

}

