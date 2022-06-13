package com.duaa.project.orderdetails;

	

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
import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class OrderdetailsController {
		

		private final OrderdetailsModelAssembler assembler;
		private final OrderdetailsRepository repository;

		@Autowired
		OrderdetailsController(OrderdetailsRepository repository, OrderdetailsModelAssembler assembler) {

			this.repository = repository;
			this.assembler = assembler;
		}

		@GetMapping("/orderdetails")
		CollectionModel<EntityModel<Orderdetails>> all() {

			List<EntityModel<Orderdetails>> orderdetails = repository.findAll().stream().map(assembler::toModel)
					.collect(Collectors.toList());

			return CollectionModel.of(orderdetails, linkTo(methodOn(OrderdetailsController.class).all()).withSelfRel());
		}

		@DeleteMapping("/orderdetails/{id}")
		void deletePatient(@PathVariable String id) {
			repository.deleteById(id);
		}

	// end::get-aggregate-root[]

		@PostMapping("/orderdetails")
		Orderdetails newPatient(@RequestBody Orderdetails neworderdetails) {
			return repository.save(neworderdetails);
		}

	// Single item

		@GetMapping("/orderdetails/{id}")
		public EntityModel<Orderdetails> one(@PathVariable String i) {

			Orderdetails orderdetails = repository.findById(i) //
					.orElseThrow(() -> new OrderdetailsNotFoundException(i));

			return assembler.toModel(orderdetails);
		}

		@PutMapping("/orderdetails/{id}")
		Orderdetails replaceEmployee(@RequestBody Orderdetails neworderdetails, @PathVariable String id) {

			return repository.findById(id).map(orderdetails -> {
				orderdetails.setOrderNumber(neworderdetails.getOrderNumber());
				orderdetails.setCrderLineNumber(neworderdetails.getCrderLineNumber());
				orderdetails.setProductCode(neworderdetails.getProductCode());
				orderdetails.setQuantityOrderd(neworderdetails.getQuantityOrderd());
				orderdetails.setPriceEach(neworderdetails.getPriceEach());

				return repository.save(orderdetails);
			}).orElseGet(() -> {
				return repository.save(neworderdetails);
			});
		}

	}


