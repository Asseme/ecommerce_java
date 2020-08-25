package org.sid.ecommerce.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Category implements Serializable {

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String photo;
	@OneToMany(mappedBy = "category")
	private Collection<Product> products;
	public Category(Long id, String name, String description, String photo, Collection<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.photo = photo;
		this.products = products;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Collection<Product> getProducts() {
		return products;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public void setProducts(Collection<Product> products) {
		this.products = products;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
