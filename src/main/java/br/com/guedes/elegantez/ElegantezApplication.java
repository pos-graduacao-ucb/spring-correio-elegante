package br.com.guedes.elegantez;

import br.com.guedes.elegantez.domain.User;
import br.com.guedes.elegantez.domain.enums.Profile;
import br.com.guedes.elegantez.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class ElegantezApplication implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	@Autowired
	private BCryptPasswordEncoder bc;

	public static void main(String[] args) {
		SpringApplication.run(ElegantezApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User gabriela = new User(null, "Gabriela", "azooiverde", "zooiv3rde@gmail.com", bc.encode("123"), "23", "feminino");
		gabriela.addProfile(Profile.ADMIN);

		repository.deleteAll();
		repository.saveAll(Arrays.asList(gabriela));
	}

}
