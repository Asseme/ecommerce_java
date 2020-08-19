package org.sid.ecommerce.entities.dao;

import java.util.List;

import org.sid.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
	@RestResource(path="selectedproduct")
	public List<Product> findBySelectedIsTrue();
	
	@RestResource(path="productByKeyword")
	public List<Product> findByNameContains(@Param("mc") String mc);
}
