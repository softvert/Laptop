package com.example.Laptop;

import com.example.Laptop.entity.Laptop;
import com.example.Laptop.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LaptopApplication {


	public static void main(String[] args) {

	 ApplicationContext context = SpringApplication.run(LaptopApplication.class, args);
	 LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		//Crear Laptop
		Laptop laptop1= new Laptop(1L,"Notebook acer i3", 315.00, 10);
		Laptop laptop2= new Laptop(2L,"Notebook acer i5", 315.00, 10);
		Laptop laptop3= new Laptop(3L,"Notebook acer i7", 315.00, 10);

		//Almacenamos laptop
		System.out.println("Lista de laptop en el almacen: "+laptopRepository.findAll().size());
		laptopRepository.save(laptop1);
		laptopRepository.save(laptop2);
		laptopRepository.save(laptop3);

	}

}
