package com.milhome.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.milhome.curso.entities.Category;
import com.milhome.curso.entities.Order;
import com.milhome.curso.entities.OrderItem;
import com.milhome.curso.entities.Payment;
import com.milhome.curso.entities.Product;
import com.milhome.curso.entities.User;
import com.milhome.curso.entities.enums.OrderStatus;
import com.milhome.curso.repositories.CategoryRepository;
import com.milhome.curso.repositories.OrderItemRepository;
import com.milhome.curso.repositories.OrderRepository;
import com.milhome.curso.repositories.ProductRepository;
import com.milhome.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository itemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria", "maria@gmail.com", "988888888", "12345");
		User u2 = new User(null, "João", "joao@gmail.com", "977777777", "12345");
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.WAITING_PAYMENT);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.PAID);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAITING_PAYMENT);
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPreco());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPreco());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPreco());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPreco());
		itemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2022-01-10T19:53:07Z"), o1);
		o1.setPayment(pay1);
		orderRepository.saveAll(Arrays.asList(o1));
		
	}
	
}
