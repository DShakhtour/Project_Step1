package com.duaa.project.category;

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
public class CategoryController {

	private final CategoryModelAssembler assembler;
	private final CategoryRepository repository;

	@Autowired
	CategoryController(CategoryRepository repository, CategoryModelAssembler assembler) {

		this.repository = repository;
		this.assembler = assembler;
	}

	@GetMapping("/category")
	CollectionModel<EntityModel<Category>> all() {

		List<EntityModel<Category>> category = repository.findAll().stream().map(assembler::toModel)
				.collect(Collectors.toList());

		return CollectionModel.of(category, linkTo(methodOn(CategoryController.class).all()).withSelfRel());
	}

	@DeleteMapping("/category/{id}")
	void deletePatient(@PathVariable int id) {
		repository.deleteById(id);
	}

// end::get-aggregate-root[]

	@PostMapping("/category")
	Category newPatient(@RequestBody Category newcategory) {
		return repository.save(newcategory);
	}

// Single item

	@GetMapping("/category/{id}")
	public EntityModel<Category> one(@PathVariable String string) {

		Category category = repository.findById(null) //
				.orElseThrow(() -> new CategoryNotFoundException(null));

		return assembler.toModel(category);
	}

	@PutMapping("/category/{id}")
	Category replaceEmployee(@RequestBody Category newcategory, @PathVariable int id) {

		return repository.findById(id).map(category -> {
			category.setProductLine(newcategory.getProductLine());
			category.setTextDescription(newcategory.getTextDescription());
			category.setHtmlDescrip(newcategory.getHtmlDescrip());
			category.setImage(newcategory.getImage());

			return repository.save(category);
		}).orElseGet(() -> {
			return repository.save(newcategory);
		});
	}

}
