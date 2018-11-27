package com.example.demo;

import com.example.demo.domain.*;
import com.example.demo.domain.enums.CustumerType;
import com.example.demo.domain.enums.PayStatus;
import com.example.demo.domain.enums.Role;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

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

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category c1 = new Category(null, "Informatic", new ArrayList<>());
		Category c2 = new Category(null, "Office", new ArrayList<>());

		Product p1 = new Product(null, "Computer", 2000.00,  new ArrayList<>(), new HashSet<>());
		Product p2 = new Product(null, "Printer", 800.00, new ArrayList<>(), new HashSet<>());
		Product p3 = new Product(null, "Mouse", 230.00, new ArrayList<>(), new HashSet<>());

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

		Custumer cus = new Custumer(null, "Maria da Silva", "maria@gmail.com", "00000000000", CustumerType.PESSOA_FISICA, "123");
		cus.getCelPhones().addAll(Arrays.asList("6134346278", "61992081000"));

		Custumer cus2 = new Custumer(null, "Lucas Daniel", "lukys.taylor@gmail.com", "00000000000", CustumerType.PESSOA_FISICA, "123");
		cus2.addRole(Role.ADMIN);
		cus2.getCelPhones().addAll(Arrays.asList("6134346278", "61992081000"));

		Address adress1 = new Address(null, "Rua 10", "Campinas", "ap", "200", "00000000", city1, cus);
		Address adress2 = new Address(null, "Avenida Matos", "Campinas", "ap", "200", "00000000", city2, cus);
		Address adress3 = new Address(null, "Rua 10", "Campinas", "ap", "200", "00000000", city2, cus);

		cus.getAddresses().addAll(Arrays.asList(adress1, adress2));
		cus2.getAddresses().addAll(Arrays.asList(adress1, adress3));

		custumerRepository.saveAll(Arrays.asList(cus, cus2));
		addressRepository.saveAll(Arrays.asList(adress1, adress2, adress3));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Order order1 = new Order(null, sdf.parse("30/09/2018 10:22"), null, cus, adress1, new HashSet<>());
		Order order2 = new Order(null, sdf.parse("10/10/2018 10:22"), null, cus, adress2, new HashSet<>());

		Payment pay1 = new CreditCardPayment(null, PayStatus.SETTLED, order1, 6);
		order1.setPayment(pay1);

		Payment pay2 = new TicketPayment(null, PayStatus.SETTLED, order2, sdf.parse("20/10/2018 00:00"), null);
		order2.setPayment(pay2);

		cus.getOrders().addAll(Arrays.asList(order1, order2));

		orderRepository.saveAll(Arrays.asList(order1, order2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));

		OrderItem oi1 = new OrderItem(order1, p1, 0.0, 1, 2000.00);
		OrderItem oi2 = new OrderItem(order1, p3, 0.0, 2, 80.00);
		OrderItem oi3 = new OrderItem(order2, p3, 0.0, 1, 800.00);

		order1.getItems().addAll(Arrays.asList(oi1, oi2));
		order2.getItems().addAll(Arrays.asList(oi3));

		p1.getItems().addAll(Arrays.asList(oi1));
		p2.getItems().addAll(Arrays.asList(oi3));
		p3.getItems().addAll(Arrays.asList(oi2));

		orderItemRepository.saveAll(Arrays.asList(oi1		));
	}
}