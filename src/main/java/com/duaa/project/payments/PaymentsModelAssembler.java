package com.duaa.project.payments;



	import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
	import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

	import org.springframework.hateoas.EntityModel;
	import org.springframework.hateoas.server.RepresentationModelAssembler;
	import org.springframework.stereotype.Component;

	@Component
	public class PaymentsModelAssembler implements RepresentationModelAssembler<Payments, EntityModel<Payments>> {

		@Override
		public EntityModel<Payments> toModel(Payments entity) {

			return EntityModel.of(entity, linkTo(methodOn(PaymentsController.class).one(entity.getCustomerNumber())).withSelfRel(),
					linkTo(methodOn(PaymentsController.class).all()).withRel("Payments"));

		}

	}


