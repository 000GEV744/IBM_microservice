package com.ms.boot.FirstWebDemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ms.boot.FirstWebDemo.product.Product;
import com.ms.boot.FirstWebDemo.product.ProductJPARepository;


@SpringBootApplication
public class FirstWebDemoApplication {
	
	@Autowired
	ProductJPARepository repo;

	public static void main(String[] args) {
		SpringApplication.run(FirstWebDemoApplication.class, args);
		}
	
	@Bean
	CommandLineRunner inspect(ApplicationContext ctx) {
		return(r) -> {
			int beanCount= ctx.getBeanDefinitionCount();
			System.out.println("bean count:"+beanCount);
			String[] beans= ctx.getBeanDefinitionNames();
			for(int i=0;i<beanCount;i++) {
				System.out.println("bean:"+beans[i]);
			}
			
			List<Product> products = new ArrayList<Product>();
			repo.save(new Product(10, "Lego 300", "Space Craft Lego", 900.76));
			repo.save(new Product(11, "Bass Guitar", "6 Strings", 800.00));
			repo.save(new Product(12, "Electric Kettle", "5 ltrs", 200.78));
			repo.save(new Product(13, "Solar Powered Robo", "8 hours battery life", 10000.00));
			repo.save(new Product(14, "Doll", "Barbie", 23000.00));
			/*
			/*
			 * products.stream().map((p) -> (repo.save(p))
			 * 
			 * 
			 * 
			 * );
			 */

			System.out.println("Saved " + products.size());
			
			
			};
		
	}
	

}
