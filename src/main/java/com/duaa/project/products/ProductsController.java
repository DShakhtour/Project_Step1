package com.duaa.project.products;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
public class ProductsController {

	private final ProductsRepository repository;
	private final ProductsModelAssembler assembler;

	@Autowired
	ProductsController(ProductsRepository repository, ProductsModelAssembler assembler) {

		this.repository = repository;
		this.assembler = assembler;

	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/products")
	public CollectionModel<EntityModel<Products>> all() {

		List<EntityModel<Products>> patients = repository.findAll().stream() //
				.map(assembler::toModel) //
				.collect(Collectors.toList());

		return CollectionModel.of(patients, linkTo(methodOn(ProductsController.class).all()).withSelfRel());
	}
	// end::get-aggregate-root[]

	@PostMapping("/products")
	ResponseEntity<?> newProducts(@Valid @RequestBody Products newProducts) {

		  EntityModel<Products> entityModel = assembler.toModel(repository.save(newProducts));

		  return ResponseEntity //
		      .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
		      .body(entityModel);
	}

	// Single item

	@GetMapping("/products/{productCode}")
	public EntityModel<Products> one(@PathVariable int productCode) {

		Products patient = repository.findById(productCode) //
				.orElseThrow(() -> new ProductsNotFoundException(productCode));

		return assembler.toModel(patient);
	}

	@PutMapping("/products/{productCode}")
	ResponseEntity<?> replaceProducts(@RequestBody Products newProducts, @PathVariable int productCode) {

		Products updatedProduct = repository.findById(productCode) //
				.map(products -> {
					products.setProductCode(newProducts.getProductCode());
					products.setProductName(newProducts.getProductName());
					products.setProductScale(newProducts.getProductScale());
					products.setProductVendor(newProducts.getProductVendor());
					products.setProductDescription(newProducts.getProductDescription());
					products.setQuantityilStock(newProducts.getQuantityilStock());
					products.setBuyPrice(newProducts.getBuyPrice());
					products.setMSRP(newProducts.getMSRP());
					return repository.save(products);
				}) //
				.orElseGet(() -> {
					newProducts.setProductCode(productCode);
					return repository.save(newProducts);
				});

		EntityModel<Products> entityModel = assembler.toModel(updatedProduct);

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@DeleteMapping("/products/delete/{productCode}")
	ResponseEntity<?> deleteProducts(@PathVariable int productCode) {

		repository.deleteById(productCode);

		return ResponseEntity.noContent().build();
	}

}
