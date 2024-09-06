package com.scaler.ProductService;

import com.scaler.ProductService.models.Product;
import com.scaler.ProductService.projections.ProductWithIdAndTitle;
import com.scaler.ProductService.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceApplicationTests {

	@Autowired
	private ProductRepository productRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void testQueries(){
		List<ProductWithIdAndTitle> products = productRepository.someRandomQuery();

		ProductWithIdAndTitle product = productRepository.doSomething(3L);
		System.out.println(product.getId());
		System.out.println(product.getTitle());

		Product product1 = productRepository.doSomethingSQL();

		System.out.println("DEBUG");
	}

}
