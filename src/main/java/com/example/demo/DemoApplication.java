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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;


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
		Product p12 = new Product(null, "Product 12", 10.00, new ArrayList<>(), new HashSet<>());
		Product p13 = new Product(null, "Product 13", 10.00, new ArrayList<>(), new HashSet<>());
		Product p14 = new Product(null, "Product 14", 10.00, new ArrayList<>(), new HashSet<>());
		Product p15 = new Product(null, "Product 15", 10.00, new ArrayList<>(), new HashSet<>());
		Product p16 = new Product(null, "Product 16", 10.00, new ArrayList<>(), new HashSet<>());
		Product p17 = new Product(null, "Product 17", 10.00, new ArrayList<>(), new HashSet<>());
		Product p18 = new Product(null, "Product 18", 10.00, new ArrayList<>(), new HashSet<>());
		Product p19 = new Product(null, "Product 19", 10.00, new ArrayList<>(), new HashSet<>());
		Product p20 = new Product(null, "Product 20", 10.00, new ArrayList<>(), new HashSet<>());
		Product p21 = new Product(null, "Product 21", 10.00, new ArrayList<>(), new HashSet<>());
		Product p22 = new Product(null, "Product 22", 10.00, new ArrayList<>(), new HashSet<>());
		Product p23 = new Product(null, "Product 23", 10.00, new ArrayList<>(), new HashSet<>());
		Product p24 = new Product(null, "Product 24", 10.00, new ArrayList<>(), new HashSet<>());
		Product p25 = new Product(null, "Product 25", 10.00, new ArrayList<>(), new HashSet<>());
		Product p26 = new Product(null, "Product 26", 10.00, new ArrayList<>(), new HashSet<>());
		Product p27 = new Product(null, "Product 27", 10.00, new ArrayList<>(), new HashSet<>());
		Product p28 = new Product(null, "Product 28", 10.00, new ArrayList<>(), new HashSet<>());
		Product p29 = new Product(null, "Product 29", 10.00, new ArrayList<>(), new HashSet<>());
		Product p30 = new Product(null, "Product 30", 10.00, new ArrayList<>(), new HashSet<>());
		Product p31 = new Product(null, "Product 31", 10.00, new ArrayList<>(), new HashSet<>());
		Product p32 = new Product(null, "Product 32", 10.00, new ArrayList<>(), new HashSet<>());
		Product p33 = new Product(null, "Product 33", 10.00, new ArrayList<>(), new HashSet<>());
		Product p34 = new Product(null, "Product 34", 10.00, new ArrayList<>(), new HashSet<>());
		Product p35 = new Product(null, "Product 35", 10.00, new ArrayList<>(), new HashSet<>());
		Product p36 = new Product(null, "Product 36", 10.00, new ArrayList<>(), new HashSet<>());
		Product p37 = new Product(null, "Product 37", 10.00, new ArrayList<>(), new HashSet<>());
		Product p38 = new Product(null, "Product 38", 10.00, new ArrayList<>(), new HashSet<>());
		Product p39 = new Product(null, "Product 39", 10.00, new ArrayList<>(), new HashSet<>());
		Product p40 = new Product(null, "Product 40", 10.00, new ArrayList<>(), new HashSet<>());
		Product p41 = new Product(null, "Product 41", 10.00, new ArrayList<>(), new HashSet<>());
		Product p42 = new Product(null, "Product 42", 10.00, new ArrayList<>(), new HashSet<>());
		Product p43 = new Product(null, "Product 43", 10.00, new ArrayList<>(), new HashSet<>());
		Product p44 = new Product(null, "Product 44", 10.00, new ArrayList<>(), new HashSet<>());
		Product p45 = new Product(null, "Product 45", 10.00, new ArrayList<>(), new HashSet<>());
		Product p46 = new Product(null, "Product 46", 10.00, new ArrayList<>(), new HashSet<>());
		Product p47 = new Product(null, "Product 47", 10.00, new ArrayList<>(), new HashSet<>());
		Product p48 = new Product(null, "Product 48", 10.00, new ArrayList<>(), new HashSet<>());
		Product p49 = new Product(null, "Product 49", 10.00, new ArrayList<>(), new HashSet<>());
		Product p50 = new Product(null, "Product 50", 10.00, new ArrayList<>(), new HashSet<>());
		c1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		c1.getProducts().addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
		c2.getProducts().addAll(Arrays.asList(p2));

		p12.getCategories().add(c1);
		p13.getCategories().add(c1);
		p14.getCategories().add(c1);
		p15.getCategories().add(c1);
		p16.getCategories().add(c1);
		p17.getCategories().add(c1);
		p18.getCategories().add(c1);
		p19.getCategories().add(c1);
		p20.getCategories().add(c1);
		p21.getCategories().add(c1);
		p22.getCategories().add(c1);
		p23.getCategories().add(c1);
		p24.getCategories().add(c1);
		p25.getCategories().add(c1);
		p26.getCategories().add(c1);
		p27.getCategories().add(c1);
		p28.getCategories().add(c1);
		p29.getCategories().add(c1);
		p30.getCategories().add(c1);
		p31.getCategories().add(c1);
		p32.getCategories().add(c1);
		p33.getCategories().add(c1);
		p34.getCategories().add(c1);
		p35.getCategories().add(c1);
		p36.getCategories().add(c1);
		p37.getCategories().add(c1);
		p38.getCategories().add(c1);
		p39.getCategories().add(c1);
		p40.getCategories().add(c1);
		p41.getCategories().add(c1);
		p42.getCategories().add(c1);
		p43.getCategories().add(c1);
		p44.getCategories().add(c1);
		p45.getCategories().add(c1);
		p46.getCategories().add(c1);
		p47.getCategories().add(c1);
		p48.getCategories().add(c1);
		p49.getCategories().add(c1);
		p50.getCategories().add(c1);

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

		productRepository.saveAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));

		Custumer cus = new Custumer(null, "Maria da Silva", "maria@gmail.com", "00000000000", CustumerType.PESSOA_FISICA, bCryptPasswordEncoder.encode("123"));
		cus.getCelPhones().addAll(Arrays.asList("6134346278", "61992081000"));

		Custumer cus2 = new Custumer(null, "Lucas Daniel", "lukys.taylor@gmail.com", "00000000000", CustumerType.PESSOA_FISICA, bCryptPasswordEncoder.encode("123"));
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