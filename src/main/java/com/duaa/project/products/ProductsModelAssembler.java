package com.duaa.project.products;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ProductsModelAssembler implements RepresentationModelAssembler<Products, EntityModel<Products>> {

	@Override
	public EntityModel<Products> toModel(Products entity) {

		return EntityModel.of(entity, linkTo(methodOn(ProductsController.class).one((int) entity.getProductCode())).withSelfRel(),
				linkTo(methodOn(ProductsController.class).all()).withRel("products"));

	}

}