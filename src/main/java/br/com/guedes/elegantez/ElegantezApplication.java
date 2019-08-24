package br.com.guedes.elegantez;

import br.com.guedes.elegantez.domain.User;
import br.com.guedes.elegantez.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ElegantezApplication implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ElegantezApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		User gaby = new User(null, "gabriela", "Java", "azooiverde", "ety", "adad");
		User roro = new User(null, "kralhoooooo", "Java", "azooiverde", "ety", "adad");
		repository.saveAll(Arrays.asList(gaby, roro));
	}

}
