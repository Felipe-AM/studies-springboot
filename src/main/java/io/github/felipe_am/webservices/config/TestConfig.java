package io.github.felipe_am.webservices.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.github.felipe_am.webservices.entities.Order;
import io.github.felipe_am.webservices.entities.User;
import io.github.felipe_am.webservices.entities.enums.OrderStatus;
import io.github.felipe_am.webservices.repositories.OrderRepository;
import io.github.felipe_am.webservices.repositories.UserRepository;

/*
 * CommandLineRunner: interface usada para executar código assim que a aplicação é iniciada. 
 * Ela é especialmente útil para tarefas de inicialização
 * 
 * @Configuration -> diz ao spring que se trata de uma classe específica de configuração
 * @Profile("test") -> classe de configuração específica para o perfil de teste do projeto
 * 
 */

@Configuration 
@Profile("test") 
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
	

}
