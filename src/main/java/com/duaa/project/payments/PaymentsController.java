package com.duaa.project.payments;

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
public class PaymentsController {

	private final PaymentsModelAssembler assembler;
	private final PaymentsRepository repository;

	@Autowired
	PaymentsController(PaymentsRepository repository, PaymentsModelAssembler assembler) {

		this.repository = repository;
		this.assembler = assembler;
	}

	@GetMapping("/Payments")
	CollectionModel<EntityModel<Payments>> all() {

		List<EntityModel<Payments>> payments = repository.findAll().stream().map(assembler::toModel)
				.collect(Collectors.toList());

		return CollectionModel.of(payments, linkTo(methodOn(PaymentsController.class).all()).withSelfRel());
	}

	@DeleteMapping("/Payments/{id}")
	void deletePayments(@PathVariable int id) {
		repository.deleteById(id);
	}

	// end::get-aggregate-root[]

	@PostMapping("/Payments")
	Payments newPatient(@RequestBody Payments newPayments) {
		return repository.save(newPayments);
	}

	// Single item

	@GetMapping("/Payments/{id}")
	public EntityModel<Payments> one(@PathVariable int id) {

		Payments payments = repository.findById(id) //
				.orElseThrow(() -> new PaymentsNotFoundException(id));

		return assembler.toModel(payments);
	}

	@PutMapping("/Payments/{id}")
	Payments replaceEmployee(@RequestBody Payments newPayments, @PathVariable int id) {

		return repository.findById(id).map(Payments -> {
			Payments.setCustomerNumber(newPayments.getCustomerNumber());
			Payments.setCheckNumber(newPayments.getCheckNumber());
			Payments.setPaymentDate(newPayments.getPaymentDate());
			Payments.setAmount(newPayments.getAmount());

			return repository.save(Payments);
		}).orElseGet(() -> {
			return repository.save(newPayments);
		});
	}

}