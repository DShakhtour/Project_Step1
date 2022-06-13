package com.duaa.project.category;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;


@Component
public class CategoryModelAssembler implements RepresentationModelAssembler<Category, EntityModel<Category>> {

	@Override
	public EntityModel<Category> toModel(Category entity) {

		return EntityModel.of(entity, linkTo(methodOn(CategoryController.class).one(entity.getProductLine())).withSelfRel(),
				linkTo(methodOn(CategoryController.class).all()).withRel("category"));

	}

}

