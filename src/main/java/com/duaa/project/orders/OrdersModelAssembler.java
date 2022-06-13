package com.duaa.project.orders;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;


@Component
public class OrdersModelAssembler implements RepresentationModelAssembler<Orders, EntityModel<Orders>> {

	@Override
	public EntityModel<Orders> toModel(Orders entity) {

		return EntityModel.of(entity, linkTo(methodOn(OrdersController.class).one(entity.getOrderNumber())).withSelfRel(),
				linkTo(methodOn(OrdersController.class).all()).withRel("orderdetails"));

	}

}
