package com.duaa.project.orderdetails;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class OrderdetailsModelAssembler implements RepresentationModelAssembler<Orderdetails, EntityModel<Orderdetails>> {

	@Override
	public EntityModel<Orderdetails> toModel(Orderdetails entity) {

		return EntityModel.of(entity, linkTo(methodOn(OrderdetailsController.class).one(entity.getProductCode())).withSelfRel(),
				linkTo(methodOn(OrderdetailsController.class).all()).withRel("orderdetails"));

	}

}
