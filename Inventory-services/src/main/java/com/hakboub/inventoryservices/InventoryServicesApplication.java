package com.hakboub.inventoryservices;

import com.hakboub.inventoryservices.entities.Product;
import com.hakboub.inventoryservices.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServicesApplication.class, args);
	}
 @Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return  args -> {
			productRepository.save(Product.builder()
							.id(UUID.randomUUID().toString())
							.nom("Laptop")
							.prix(8500)
							.quantity(13)
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.nom("Iphone")
					.prix(11400)
					.quantity(10)
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.nom("Samsung")
					.prix(2300)
					.quantity(20)
					.build());

			productRepository.findAll().forEach(p ->{
							System.out.println(p.toString());
			});
		};
 }
}
