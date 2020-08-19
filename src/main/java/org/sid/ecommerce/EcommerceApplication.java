package org.sid.ecommerce;

import java.util.Random;

import org.sid.ecommerce.entities.Category;
import org.sid.ecommerce.entities.Product;
import org.sid.ecommerce.entities.dao.CategoryRepository;
import org.sid.ecommerce.entities.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Random rnd = new Random();
		categoryRepository.save(new Category(null,"Computer",null,null));
		categoryRepository.save(new Category(null,"Printer",null,null));
		categoryRepository.save(new Category(null,"Smartphone",null,null));
		categoryRepository.findAll().forEach(c->{
			for(int i = 0; i<10; i++) {
				Product p = new Product();
				p.setName(RandomString.make(18));
				p.setCurrentPrice(100.0+rnd.nextDouble());
				p.setAvaible(rnd.nextBoolean());
				p.setPromotion(rnd.nextBoolean());
				p.setSelected(rnd.nextBoolean());
				p.setCategory(c);
				productRepository.save(p);
			}
				
		});
	}

}
