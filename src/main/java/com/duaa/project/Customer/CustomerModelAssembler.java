package com.duaa.project.Customer;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;


	@Component
	public class CustomerModelAssembler implements RepresentationModelAssembler<Customer, EntityModel<Customer>> {

		@Override
		public EntityModel<Customer> toModel(Customer entity) {

			return EntityModel.of(entity, linkTo(methodOn(CustomerController.class)
					.one(Integer.parseInt(entity.getCustomerNumber()+""))).withSelfRel(),
					linkTo(methodOn(CustomerController.class).all()).withRel("customer"));

		}

	}


