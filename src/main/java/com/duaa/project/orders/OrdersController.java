package com.duaa.project.orders;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController {
	

	private final OrdersModelAssembler assembler;
	private final OrdersRepository repository;

	@Autowired
	OrdersController(OrdersRepository repository, OrdersModelAssembler assembler) {

		this.repository = repository;
		this.assembler = assembler;
	}

	@GetMapping("/")
	CollectionModel<EntityModel<Orders>> all() {
		
		System.out.println("AAAAA");

		List<EntityModel<Orders>> orderdetails = repository.findAll().stream().map(assembler::toModel)
				.collect(Collectors.toList());

		return CollectionModel.of(orderdetails, linkTo(methodOn(OrdersController.class).all()).withSelfRel());
	}

	@DeleteMapping("/orders/{id}")
	void deletePatient(@PathVariable int id) {
		repository.deleteById(id);
	}

// end::get-aggregate-root[]

	@PostMapping("/orders")
	Orders newPatient(@RequestBody Orders neworderdetails) {
		return repository.save(neworderdetails);
	}

// Single item

	@GetMapping("/orders/{id}")
	public EntityModel<Orders> one(@PathVariable int id) {

		Orders orderdetails = repository.findById(id) //
				.orElseThrow(() -> new OrdersNotFoundException(id));

		return assembler.toModel(orderdetails);
	}

	@PutMapping("/orders/{OrderNumber}")
	Orders replaceorders(@RequestBody Orders neworders, @PathVariable int OrderNumber) {

		return repository.findById(OrderNumber).map(orders -> {
			orders.setOrderNumber(neworders.getOrderNumber());
			orders.setOrderNumber(neworders.getOrderNumber());
			orders.setOrderDate(neworders.getOrderDate());
			orders.setRequiredDate(neworders.getRequiredDate());
			orders.setShippedDate(neworders.getShippedDate());

			return repository.save(orders);
		}).orElseGet(() -> {
			return repository.save(neworders);
		});
	}

}

