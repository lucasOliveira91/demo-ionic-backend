package com.example.demo;

import com.example.demo.domain.*;
import com.example.demo.domain.enums.CustumerType;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private CustumerRepository custumerRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category c1 = new Category(null, "Informatic", new ArrayList<>());
		Category c2 = new Category(null, "Office",  new ArrayList<>());

		Product p1 =  new Product(null, "Computer", 2000.00,  new ArrayList<>());
		Product p2 =  new Product(null, "Printer", 800.00,  new ArrayList<>());
		Product p3 =  new Product(null, "Mouse", 230.00,  new ArrayList<>());

		c1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		c2.getProducts().addAll(Arrays.asList(p2));

		p1.getCategories().addAll(Arrays.asList(c1));
		p2.getCategories().addAll(Arrays.asList(c1, c2));
		p3.getCategories().addAll(Arrays.asList(c1));

		State s1 = new State(null, "Minas Gerais", new ArrayList<>());
		State s2 = new State(null, "São Paulo", new ArrayList<>());

		City city1 = new City(null, "Uberlandia", s1);
		City city2 = new City(null, "São Paulo", s2);
		City city3 = new City(null, "Campinas", s2);

		s1.getCities().addAll(Arrays.asList(city1));
		s1.getCities().addAll(Arrays.asList(city1, city3));

		stateRepository.save(s1);
		stateRepository.save(s2);

		cityRepository.saveAll(Arrays.asList(city1, city2, city3));
		categoryRepository.saveAll(Arrays.asList(c1, c2));

		productRepository.save(p1);

		Custumer cus = new Custumer(null, "Maria da Silva", "maria@gmail.com","00000000000", CustumerType.PESSOA_FISICA);
		cus.getCelPhones().addAll(Arrays.asList("6134346278", "61992081000"));

		Address adress1 = new Address(null, "Rua 10", "Campinas","ap", "200", "00000000", city1, cus);
		Address adress2 = new Address(null, "Avenida Matos", "Campinas","ap", "200", "00000000", city2, cus);

		cus.getAddresses().addAll(Arrays.asList(adress1, adress2));

		custumerRepository.save(cus);
		addressRepository.saveAll(Arrays.asList(adress1, adress2));
	}
}
